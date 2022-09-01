package org.fasttrackit.Curs19.transactionapp.service.transaction;

import org.fasttrackit.Curs19.transactionapp.model.transaction.Transaction;
import org.fasttrackit.Curs19.transactionapp.model.transaction.TransactionType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Primary
public class TransactionReader implements TransactionProvider{
    @Value("${file.transactions}")
    private String filePath;
    @Override
    public List<Transaction> getTransactionList() {
        try {
            return Files.lines(Path.of(filePath))
                    .map(this::lineToCountry)
                    .toList();
        } catch (IOException e) {
            System.err.println("Could not find file");
        }
        return List.of();
    }

    private Transaction lineToCountry(String line) {
        String[] tokens = line.split("\\|");
        return new Transaction(tokens[0],
                TransactionType.stringToEnum(tokens[1]),
                Double.parseDouble(tokens[2]));
    }
}
