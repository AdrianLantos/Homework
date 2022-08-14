package org.fasttrackit.Curs19.transactionapp.service.transaction;

import org.fasttrackit.Curs19.transactionapp.model.transaction.Transaction;

import java.util.List;

public interface TransactionProvider {
    public List<Transaction> getTransactionList();
}
