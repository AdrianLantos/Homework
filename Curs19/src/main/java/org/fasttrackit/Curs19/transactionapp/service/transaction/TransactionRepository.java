package org.fasttrackit.Curs19.transactionapp.service.transaction;

import org.fasttrackit.Curs19.transactionapp.model.transaction.Transaction;
import org.fasttrackit.Curs19.transactionapp.model.transaction.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    List<Transaction> findByProduct (String product);
    List<Transaction> findByType (TransactionType type);
    List<Transaction> findByAmountGreaterThan (double minAmount);
    List<Transaction> findByAmountLessThan (double maxAmount);
    List<Transaction> findByTypeAndAmountGreaterThan(TransactionType type, double Amount);
    List<Transaction> findByTypeAndAmountLessThan(TransactionType type, double Amount);
    List<Transaction> findByAmountBetween(double minAmount, double maxAmount);
    List<Transaction> findByTypeAndAmountBetween(TransactionType type, double minAmount, double maxAmount);


    Transaction findById(int id);







}
