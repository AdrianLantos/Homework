package org.fasttrackit.Curs19.transactionapp.service.transaction;

import org.fasttrackit.Curs19.transactionapp.model.transaction.Transaction;
import org.fasttrackit.Curs19.transactionapp.model.transaction.TransactionType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemoryTransactionProvider implements TransactionProvider {
    @Override
    public List<Transaction> getTransactionList() {
        List<Transaction> transactionList = new ArrayList<>();
        transactionList.add(new Transaction("Book", TransactionType.BUY, 120));
        transactionList.add(new Transaction("Book", TransactionType.SELL, 80));
        transactionList.add(new Transaction("Course", TransactionType.BUY, 400));
        return transactionList;
    }
}
