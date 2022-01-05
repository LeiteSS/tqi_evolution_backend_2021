package br.com.tqi.loanapi.controller;

import br.com.tqi.loanapi.controller.docs.UsersControllerDocs;
import br.com.tqi.loanapi.dto.LoginDTO;
import br.com.tqi.loanapi.dto.ProfileInformationDTO;
import br.com.tqi.loanapi.dto.ProfileDTO;
import br.com.tqi.loanapi.dto.TokenDTO;
import br.com.tqi.loanapi.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

    @PostMapping("/signIn")
    public ResponseEntity<TokenDTO> signIn(@RequestBody @Valid LoginDTO loginDTO)
    {

        return ResponseEntity.ok(service.signIn(loginDTO));
    }

    @Override
    @GetMapping("/me")
    public ResponseEntity<ProfileDTO> me(HttpServletRequest request)
    {
        String header = request.getHeader("Authorization");

        if (header == null || header.isEmpty() || !header.startsWith("Bearer ")) {
            return null;
        }
        String token = header.substring(7, header.length());

        return ResponseEntity.ok(service.profileInformation(token));
    }
}
