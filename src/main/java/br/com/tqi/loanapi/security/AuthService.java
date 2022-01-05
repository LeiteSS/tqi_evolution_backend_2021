package br.com.tqi.loanapi.security;

import br.com.tqi.loanapi.model.User;
import br.com.tqi.loanapi.repository.UsersRepository;
import br.com.tqi.loanapi.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService  {

    @Autowired
    private UsersService usersService;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = usersRepository.findByEmail(username);

        if (user == null) {
            user = usersRepository.findByUsername(username);
        }

        if (!validUser(user)) {
            throw new UsernameNotFoundException("Usuario sem permissão");
        }

        return user;
    }

    private boolean validUser(User user) {
        boolean validUser = false;

        if (user != null && user.getRoles() != null) {
            validUser = true;
        }

        return validUser;
    }
}
