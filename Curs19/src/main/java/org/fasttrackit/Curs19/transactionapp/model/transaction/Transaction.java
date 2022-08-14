package org.fasttrackit.Curs19.transactionapp.model.transaction;

import lombok.Getter;
import lombok.Setter;
import org.fasttrackit.Curs19.transactionapp.exception.TransactionNotFound;

@Setter
@Getter
public class Transaction {
    private int id;
    private String product;
    private TransactionType type;
    private double amount;

    public Transaction(int id, String product, TransactionType type, double amount) {
        this.id = id;
        this.product = product;
        this.type = type;
        this.amount = amount;
    }

    public Transaction(String product, TransactionType type, double amount) {
        this.product = product;
        this.type = type;
        this.amount = amount;
    }
}