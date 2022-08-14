package org.fasttrackit.Curs19.transactionapp.controller.transaction;

import lombok.RequiredArgsConstructor;
import org.fasttrackit.Curs19.transactionapp.exception.TransactionNotFound;
import org.fasttrackit.Curs19.transactionapp.model.transaction.Transaction;
import org.fasttrackit.Curs19.transactionapp.model.transaction.TransactionType;
import org.fasttrackit.Curs19.transactionapp.service.transaction.TransactionService;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @GetMapping
    List<Transaction> getAll(@RequestParam(required = false) String filterType, @RequestParam(required = false) String value, HttpServletRequest request) {
        if (request.getParameter("filterType") == null && request.getParameter("value") == null) {
            return transactionService.getAll();
        } else {
            if (filterType.equalsIgnoreCase("product")) {
                return transactionService.getAll(value);
            } else if (filterType.equalsIgnoreCase("type")) {
                return transactionService.getAll(filterType, value);
            } else if (filterType.equalsIgnoreCase("minAmount")) {
                return transactionService.getAll(filterType, Double.parseDouble(value));
            } else if (filterType.equalsIgnoreCase("maxAmount")) {
                return transactionService.getAll(Double.parseDouble(value));
            } else {
                throw new TransactionNotFound("Invalid parameters");
            }
        }
    }

    @GetMapping("{id}")
    public Transaction getById(@PathVariable int id) {
        return transactionService.getTransactionById(id);
    }

    //       Nu am inteles de unde ar trebui sa primim tranzactia
    @PostMapping
    public void addTransaction(@RequestParam(required = false) String product,
                               @RequestParam(required = false) String type,
                               @RequestParam(required = false) double amount) {
        transactionService.addTransaction(new Transaction(transactionService.getAll().size(), product, TransactionType.stringToEnum(type), amount));
    }

    @PutMapping("{id}")
    public void replaceTransaction(@PathVariable int id) {
        int idReplacer = transactionService.getAll().stream().filter(transaction -> transaction.getId() == id).map(Transaction::getId).findFirst().get();
        transactionService.replaceTransaction(id, new Transaction(idReplacer, "Lapotop", TransactionType.BUY, 4000));
    }

    @DeleteMapping("{id}")
    public void deleteTransaction(int id) {
        transactionService.deleteTransaction(id);
    }

    @GetMapping("/reports/type")
    public Map<Enum, List<Transaction>> getTransactionType() {
        return transactionService.getTransactionType();
    }

    @GetMapping("/reports/product")
    public Map<String, List<Transaction>> getTransactionProduct() {
        return transactionService.getTransactionProduct();
    }
}
