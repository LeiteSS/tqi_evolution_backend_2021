package br.com.tqi.loanapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoanDTO {

    @NotNull
    private LocalDate datePayment;

    @NotNull
    private Integer paymentQuantity;

    @NotNull
    @DecimalMin(value = "0.00")
    @Digits(integer = 6, fraction = 2)
    private Double value;
}
