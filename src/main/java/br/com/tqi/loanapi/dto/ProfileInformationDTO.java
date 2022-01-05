package br.com.tqi.loanapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfileInformationDTO {

    @NotNull
    private String username;

    @Size(min = 8, message = "A senha deve ter no minimo 8 caracteres.")
    @NotNull
    private String password;

    @Email(message = "Insira um email valido")
    @Pattern(regexp=".+@.+\\..+", message="Insira um email valido")
    @NotNull
    private String email;

    @NotNull
    private String name;

    @NotNull
    private String lastname;

    @CPF
    @NotNull
    private String cpf;

    @Size(min = 9, max = 9, message = "O Registro Geral (R.G.) deve ser valido.")
    @NotNull
    private String rg;

    private List<String> roles;

    @NotNull
    private Double income;

    @NotNull
    private String publicArea;

    @NotNull
    private String district;

    @NotNull
    private String city;

    @NotNull
    private String state;

    @NotNull
    private Integer houseNumber;

    @NotNull
    private String zipCode;
}
