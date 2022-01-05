package br.com.tqi.loanapi.controller;

import br.com.tqi.loanapi.controller.docs.UsersControllerDocs;
import br.com.tqi.loanapi.dto.LoginDTO;
import br.com.tqi.loanapi.dto.ProfileInformationDTO;
import br.com.tqi.loanapi.dto.ProfileDTO;
import br.com.tqi.loanapi.dto.TokenDTO;
import br.com.tqi.loanapi.service.UsersService;
import br.com.tqi.loanapi.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "https://tqi-evolution-frontend-2022.netlify.app")
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
        String token = TokenUtils.wrapperToken(request);

        return ResponseEntity.ok(service.profileInformation(token));
    }
}
