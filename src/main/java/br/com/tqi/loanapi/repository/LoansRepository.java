package br.com.tqi.loanapi.repository;

import br.com.tqi.loanapi.model.Loan;
import br.com.tqi.loanapi.repository.model.Loans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LoansRepository extends JpaRepository<Loan, Long> {

    @Query(value = "SELECT * FROM loans l, users u WHERE l.user_id = :userId AND u.id_user = :userId", nativeQuery = true)
    public List<Loans> listLoans(@Param("userId") Long userId);

    @Query(value = "SELECT * FROM loans l, users u WHERE l.id_loan = :id AND l.user_id = :userId AND u.id_user = :userId", nativeQuery = true)
    public Loans detailLoan(@Param("id") Long id, @Param("userId") Long userId);
}
