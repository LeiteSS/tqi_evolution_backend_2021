package br.com.tqi.loanapi.dto;

import lombok.Data;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Data
public class LoginDTO {

    @ApiModelProperty(value = "Email ou username")
    private String login;

    @ApiModelProperty(value = "Senha")
    private String password;

    public UsernamePasswordAuthenticationToken convert() {
        return new UsernamePasswordAuthenticationToken(login, password);
    }
}
