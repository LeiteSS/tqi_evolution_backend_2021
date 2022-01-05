package br.com.tqi.loanapi.service;

import br.com.tqi.loanapi.dto.LoanDTO;
import br.com.tqi.loanapi.exception.IsAfterThreeMonthsException;
import br.com.tqi.loanapi.exception.IsBeforeTodayException;
import br.com.tqi.loanapi.exception.IsMoreThanSixtyException;
import br.com.tqi.loanapi.model.Loan;
import br.com.tqi.loanapi.model.User;
import br.com.tqi.loanapi.repository.LoansRepository;
import br.com.tqi.loanapi.repository.UsersRepository;
import br.com.tqi.loanapi.repository.model.Loans;
import br.com.tqi.loanapi.security.TokenService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LoansService {

    private LoansRepository loansRepository;

    private TokenService tokenService;

    private UsersRepository usersRepository;

    public LoanDTO createLoan(LoanDTO loanDTO, String token) throws Exception {
        Loan loan = new Loan();
        Long userId = tokenService.getUserId(token);

        User user = usersRepository.getById(userId);

        LocalDate today = LocalDate.now();

        LocalDate threeMonths = today.plusMonths(3); //&&

        if (loanDTO.getDatePayment().isBefore(today))
        {
            throw new IsBeforeTodayException(loanDTO.getDatePayment());
        }

        if (loanDTO.getDatePayment().isAfter(threeMonths))
        {
            throw new IsAfterThreeMonthsException(loanDTO.getDatePayment());
        }

        if(loanDTO.getPaymentQuantity() > 60)
        {
            throw new IsMoreThanSixtyException(loanDTO.getPaymentQuantity());
        }

        loan.setDatePayment(loanDTO.getDatePayment());
        loan.setValue(loanDTO.getValue());
        loan.setPaymentQuantity(loanDTO.getPaymentQuantity());
        loan.setUser(user);
        loansRepository.save(loan);

        return loanDTO;
    }

    public List<Loans> listLoans(String token) {
        Long userId = tokenService.getUserId(token);

        return loansRepository.listLoans(userId);
    }
}
