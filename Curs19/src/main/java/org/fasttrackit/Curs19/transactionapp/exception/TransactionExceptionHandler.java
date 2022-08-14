package org.fasttrackit.Curs19.transactionapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TransactionExceptionHandler {
    @ExceptionHandler(TransactionNotFound.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleTransactionNotFoundException(TransactionNotFound e) {
        return new ErrorResponse(e.getMessage());
    }
}

record ErrorResponse(String message) {

}
