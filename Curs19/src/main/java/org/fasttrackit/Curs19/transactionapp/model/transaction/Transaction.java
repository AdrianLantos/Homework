package org.fasttrackit.Curs19.transactionapp.model.transaction;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Setter
@Getter
@Entity
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String product;
    @Column
    private TransactionType type;
    @Column
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