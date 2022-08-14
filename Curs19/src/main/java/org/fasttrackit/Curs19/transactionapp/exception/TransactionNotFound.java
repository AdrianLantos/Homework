package org.fasttrackit.Curs19.transactionapp.exception;

public class TransactionNotFound extends RuntimeException{
    public TransactionNotFound(String message) {
        super(message);
    }
}
