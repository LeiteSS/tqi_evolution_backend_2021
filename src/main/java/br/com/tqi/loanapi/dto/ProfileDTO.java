package br.com.tqi.loanapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDTO {

    private String username;
    private String email;
    private String name;
    private String lastname;
    private String cpf;
    private String rg;
    private Double income;
}
