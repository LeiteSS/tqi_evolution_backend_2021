package br.com.tqi.loanapi.controller;

import br.com.tqi.loanapi.controller.docs.UsersControllerDocs;
import br.com.tqi.loanapi.dto.ProfileInformationDTO;
import br.com.tqi.loanapi.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/users")
public class UsersController implements UsersControllerDocs {

    @Autowired
    private UsersService service;

    @Override
    @PostMapping("/signUp")
    public ResponseEntity<ProfileInformationDTO> signUp(@RequestBody @Valid ProfileInformationDTO profileInformationDTO)
    {
        ProfileInformationDTO responseBody = service.signUp(profileInformationDTO);

        return ResponseEntity.ok(responseBody);
    }
}
