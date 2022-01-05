package br.com.tqi.loanapi.services;

import br.com.tqi.loanapi.dto.ProfileInformationDTO;
import br.com.tqi.loanapi.model.Address;
import br.com.tqi.loanapi.model.User;
import br.com.tqi.loanapi.repository.AddressesRepository;
import br.com.tqi.loanapi.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    private UsersRepository userRepository;

    @Autowired
    private AddressesRepository addressesRepository;

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
}
