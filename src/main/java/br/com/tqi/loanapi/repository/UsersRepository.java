package br.com.tqi.loanapi.repository;

import br.com.tqi.loanapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Long> {
}
