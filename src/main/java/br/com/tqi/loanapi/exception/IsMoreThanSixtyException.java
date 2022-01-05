package br.com.tqi.loanapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IsMoreThanSixtyException extends Exception {

    public IsMoreThanSixtyException(Integer quantityPayment) {
        super("Mais do que 60 parcelas eu não faço");
    }
}
