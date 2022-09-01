package org.fasttrackit.Curs19.transactionapp.service.transaction;

import org.fasttrackit.Curs19.transactionapp.model.transaction.Transaction;
import org.fasttrackit.Curs19.transactionapp.model.transaction.TransactionType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TransactionService {
    private final TransactionRepository repository;

    public TransactionService(TransactionProvider transactionProvider, TransactionRepository repository) {
        this.repository = repository;
        repository.saveAll(transactionProvider.getTransactionList());
    }

    public List<Transaction> findByProduct(String prdouct) {
        return repository.findByProduct(prdouct);
    }

    public List<Transaction> getAll() {
        return repository.findAll();
    }

    public List<Transaction> findByType(String type) {
        return repository.findByType(TransactionType.stringToEnum(type));
    }

    public List<Transaction> findByAmountGreaterThan(double minAmount) {
        return repository.findByAmountGreaterThan(minAmount);
    }

    public List<Transaction> findByAmountLessThan(double maxAmount) {
        return repository.findByAmountLessThan(maxAmount);
    }

    public List<Transaction> findByTypeAndAmountGreaterThan(String type, double minAmount) {
        return repository.findByTypeAndAmountGreaterThan(TransactionType.stringToEnum(type), minAmount);
    }

    public List<Transaction> findByTypeAndAmountLessThan(String type, double maxAmount) {
        return repository.findByTypeAndAmountLessThan(TransactionType.stringToEnum(type), maxAmount);
    }

    public List<Transaction> findByAmountBetween(double minAmount, double maxAmount) {
        return repository.findByAmountBetween(minAmount, maxAmount);
    }

    public List<Transaction> findByTypeAmountBetween(String type, double minAmount, double maxAmount) {
        return repository.findByTypeAndAmountBetween(TransactionType.stringToEnum(type), minAmount, maxAmount);

    }

    public Transaction findById(int id) {
        return repository.findById(id);
    }

    public Transaction save(Transaction transaction) {
        return repository.save(transaction);
    }

    public void patch(int id, String product, double amount) {
        Transaction transaction = repository.findById(id);
        transaction.setProduct(product);
        transaction.setAmount(amount);
        repository.save(transaction);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

    public Map<TransactionType, Double> getTransactionTypeTotalSum() {
        return repository.findAll()
                .stream()
                .collect(Collectors.groupingBy(transaction -> transaction.getType(), Collectors.summingDouble(transaction -> transaction.getAmount())));
    }

    public Map<String, Double> getProductTotalSum() {
        return repository.findAll()
                .stream()
                .collect(Collectors.groupingBy(Transaction::getProduct, Collectors.summingDouble(Transaction::getAmount)));
    }

    public Map<TransactionType, List<Transaction>> getTransactionGroupedByType() {
        return repository.findAll()
                .stream()
                .collect(Collectors.groupingBy(Transaction::getType));
    }

    public Map<String, List<Transaction>> getTransactionGroupedByProduct() {
//        Map<String, List<Transaction>> result = new HashMap<>();
//        repository.findAll().stream().map(Transaction::getProduct).distinct().forEach(product -> result.put(product, new ArrayList<>()));
//        result.forEach((key, value) -> result.put(key, transactionList.stream()
//                .filter(transaction -> transaction.getProduct().equals(key))
//                .toList()));
        return repository.findAll()
                .stream()
                .collect(Collectors.groupingBy(Transaction::getProduct));
    }
}
    /*public List<Transaction> getAll() {
        return transactionList;
    }

    public List<Transaction> getAll(String product) {
//        Nu sunt sigur daca trebuie aruncata exceptie aici sau returnam o lista goala in cazul in care nu merge filtrarea
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
    }*/

