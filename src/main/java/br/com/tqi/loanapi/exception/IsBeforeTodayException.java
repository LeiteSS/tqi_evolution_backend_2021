package br.com.tqi.loanapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDate;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IsBeforeTodayException extends Exception  {

    public IsBeforeTodayException(LocalDate date) {
        super("Data inserida é antes de hoje");
    }
}
