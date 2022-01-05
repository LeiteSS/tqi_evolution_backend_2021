package br.com.tqi.loanapi.repository;

import br.com.tqi.loanapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsersRepository extends JpaRepository<User, Long> {

    @Query("SELECT e FROM User e JOIN FETCH e.roles WHERE e.username = (:username)")
    public User findByUsername(@Param("username") String username);

    @Query("SELECT e FROM User e JOIN FETCH e.roles WHERE e.email = (:email)")
    public User findByEmail(@Param("email") String email);
}
