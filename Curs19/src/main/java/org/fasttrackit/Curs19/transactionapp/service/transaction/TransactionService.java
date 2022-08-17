package org.fasttrackit.Curs19.transactionapp.service.transaction;

import org.fasttrackit.Curs19.transactionapp.exception.TransactionNotFound;
import org.fasttrackit.Curs19.transactionapp.model.transaction.Transaction;
import org.fasttrackit.Curs19.transactionapp.model.transaction.TransactionType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class TransactionService {
    private final List<Transaction> transactionList;

    public TransactionService(TransactionProvider transactionProvider) {
        this.transactionList = transactionProvider.getTransactionList();
        AtomicInteger i = new AtomicInteger();
        for (Transaction t : transactionList) {
            t.setId(i.getAndIncrement());
        }
    }

    public List<Transaction> getAll() {
        return transactionList;
    }

    public List<Transaction> getAll(String product) {
//        Nu sunt sigur daca trebuie aruncata exceptie aici sau returam o lista goala in cazul in care nu merge filtrarea
//        As as face daca ar trebui sa avem o exceptie, dar in continuare returnez lista chiar daca e goala
        List<Transaction> transactions = transactionList.stream()
                .filter(transaction -> transaction.getProduct().equalsIgnoreCase(product))
                .toList();
        if (transactions.size() > 0) {
            return transactions;
        } else {
            throw new TransactionNotFound("No transactions with given product");
        }
    }

    public List<Transaction> getAll(String filterType, String enumName) {
        return transactionList.stream()
                .filter(transaction -> transaction.getType().toString().equalsIgnoreCase(enumName))
                .toList();
    }

    public List<Transaction> getAll(String filterType, double minAmount) {
        return transactionList.stream()
                .filter(transaction -> transaction.getAmount() >= minAmount)
                .toList();
    }

    public List<Transaction> getAll(double maxAmount) {
        return transactionList.stream()
                .filter(transaction -> transaction.getAmount() <= maxAmount)
                .toList();
    }


    public Transaction getTransactionById(int id) {
        return transactionList.stream()
                .filter(transaction -> transaction.getId() == id)
                .findFirst()
                .orElseThrow(() -> new TransactionNotFound("Transaction not found"));
    }

    public void addTransaction(Transaction transaction) {
        transactionList.add(transaction);
    }

    public void replaceTransaction(int id, Transaction newTransaction) {
        int index = transactionList.indexOf(transactionList.stream()
                .filter(transaction -> transaction.getId() == id)
                .findFirst()
                .orElseThrow(() -> new TransactionNotFound("No transaction matching the given id"))
        );

        transactionList.remove(index);
        transactionList.add(index, newTransaction);
    }

    public void deleteTransaction(int id) {
        transactionList.remove(
                transactionList.stream()
                        .filter(transaction -> transaction.getId() == id)
                        .findFirst()
                        .orElseThrow(() -> new TransactionNotFound("No transaction matching that id found")
                        )
        );
    }

    public Map<TransactionType, List<Transaction>> getTransactionType() {
//        Map<TransactionType, List<Transaction>> result = new HashMap<>();
//        transactionList.stream().map(Transaction::getType).distinct().forEach(transactionType -> result.put(transactionType, new ArrayList<>()));
//        result.forEach((key, value) -> result.put(key, transactionList.stream()
//                .filter(transaction -> transaction.getType().equals(key))
//                .toList()));
        return transactionList.stream()
                .collect(Collectors.groupingBy (Transaction::getType));
    }


    public Map<String, List<Transaction>> getTransactionProduct() {
//        Map<String, List<Transaction>> result = new HashMap<>();
//        transactionList.stream().map(Transaction::getProduct).distinct().forEach(product -> result.put(product, new ArrayList<>()));
//        result.forEach((key, value) -> result.put(key, transactionList.stream()
//                .filter(transaction -> transaction.getProduct().equals(key))
//                .toList()));
        return transactionList.stream()
                .collect(Collectors.groupingBy(Transaction::getProduct));
    }
}
