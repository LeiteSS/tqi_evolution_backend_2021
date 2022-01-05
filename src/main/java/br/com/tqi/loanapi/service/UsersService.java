package br.com.tqi.loanapi.service;

import br.com.tqi.loanapi.dto.LoginDTO;
import br.com.tqi.loanapi.dto.ProfileInformationDTO;
import br.com.tqi.loanapi.dto.TokenDTO;
import br.com.tqi.loanapi.model.Address;
import br.com.tqi.loanapi.model.User;
import br.com.tqi.loanapi.repository.AddressesRepository;
import br.com.tqi.loanapi.repository.UsersRepository;
import br.com.tqi.loanapi.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    private UsersRepository userRepository;

    @Autowired
    private AddressesRepository addressesRepository;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

    public ProfileInformationDTO signUp(ProfileInformationDTO profileInformationDTO) {
        User user = new User();
        Address address = new Address();

        String pwd = profileInformationDTO.getPassword();
        profileInformationDTO.setPassword(new BCryptPasswordEncoder().encode(pwd));

        user.setUsername(profileInformationDTO.getUsername());
        user.setPassword(profileInformationDTO.getPassword());
        user.setEmail(profileInformationDTO.getEmail());
        user.setName(profileInformationDTO.getName());
        user.setLastname(profileInformationDTO.getLastname());
        user.setCpf(profileInformationDTO.getCpf());
        user.setRg(profileInformationDTO.getRg());
        user.setIncome(profileInformationDTO.getIncome());
        user.setRoles(profileInformationDTO.getRoles());
        User userSaved = userRepository.save(user);

        address.setPublicArea(profileInformationDTO.getPublicArea());
        address.setDistrict(profileInformationDTO.getDistrict());
        address.setZipCode(profileInformationDTO.getZipCode());
        address.setHouseNumber(profileInformationDTO.getHouseNumber());
        address.setCity(profileInformationDTO.getCity());
        address.setState(profileInformationDTO.getState());
        address.setUserId(userSaved.getId());
        addressesRepository.save(address);

        return profileInformationDTO;
    }

    public TokenDTO signIn(LoginDTO loginDTO) {
        UsernamePasswordAuthenticationToken loginData = loginDTO.convert();
        Authentication auth = authenticationManager.authenticate(loginData);
        String token = tokenService.getToken(auth);

        return new TokenDTO(token, "Bearer");
    }
}
