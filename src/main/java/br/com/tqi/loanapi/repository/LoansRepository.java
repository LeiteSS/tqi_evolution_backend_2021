package br.com.tqi.loanapi.repository;

import br.com.tqi.loanapi.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoansRepository extends JpaRepository<Loan, Long> {
}
