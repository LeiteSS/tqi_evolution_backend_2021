package br.com.tqi.loanapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDate;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IsAfterThreeMonthsException extends Exception {

    public IsAfterThreeMonthsException(LocalDate date) {
        super("Data inserida date é depois de três meses");
    }
}
