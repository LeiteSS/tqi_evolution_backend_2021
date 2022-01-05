package br.com.tqi.loanapi.controller.docs;

import br.com.tqi.loanapi.dto.ErrorDTO;
import br.com.tqi.loanapi.dto.LoginDTO;
import br.com.tqi.loanapi.dto.ProfileInformationDTO;
import br.com.tqi.loanapi.dto.TokenDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.validation.Valid;

@Api(value = "/api/v1/users",  description = "Operações relacionadas aos Usuarios")
public interface UsersControllerDocs {

    @ApiOperation(value = "Cadastrar um usuario", nickname = "signUp", notes = "", response = ProfileInformationDTO.class, responseContainer = "object", tags = { "Users", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuario Cadastrado no sistema", response = ProfileInformationDTO.class, responseContainer = "object"),
            @ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes", response = ErrorDTO.class, responseContainer = "object")})
    @PostMapping("/signUp")
    public ResponseEntity<ProfileInformationDTO> signUp(@RequestBody @Valid ProfileInformationDTO profileInformationDTO);

    @ApiOperation(value = "Logar no sistema", nickname = "signIn", notes = "", response = TokenDTO.class, responseContainer = "object", tags = { "Users", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuario Logado com sucesso!", response = TokenDTO.class, responseContainer = "object"),
            @ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes", response = ErrorDTO.class, responseContainer = "object"),
            @ApiResponse(code = 404, message = "Usuário não encontrada") })
    @PostMapping("/signIn")
    public ResponseEntity<TokenDTO> signIn(@RequestBody @Valid LoginDTO loginDTO);
}
