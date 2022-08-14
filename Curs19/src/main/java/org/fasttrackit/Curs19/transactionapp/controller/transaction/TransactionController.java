package org.fasttrackit.Curs19.transactionapp.controller.transaction;

import lombok.RequiredArgsConstructor;
import org.fasttrackit.Curs19.transactionapp.exception.TransactionNotFound;
import org.fasttrackit.Curs19.transactionapp.model.transaction.Transaction;
import org.fasttrackit.Curs19.transactionapp.model.transaction.TransactionType;
import org.fasttrackit.Curs19.transactionapp.service.transaction.TransactionService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

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
                try {
                    return transactionService.getAll(filterType, Double.parseDouble(value));
                }catch (NumberFormatException e){
                    throw new RuntimeException("Value must be a double for given filterType");
                }
            } else if (filterType.equalsIgnoreCase("maxAmount")) {
                try {
                    return transactionService.getAll(Double.parseDouble(value));
                }catch (NumberFormatException e){
                    throw new RuntimeException("Value must be a double for given filterType");
                }
            } else {
                throw new TransactionNotFound("Invalid parameters. Can filter by \"product\", \"type\", \"minAmount\" or \"maxAmount\"");
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
//        int idReplacer = transactionService.getAll().stream().map(Transaction::getId).filter(transactionId -> transactionId == id).findFirst().get();
        transactionService.replaceTransaction(id, new Transaction(id, "Lapotop", TransactionType.BUY, 4000));
    }

    @DeleteMapping("{id}")
    public void deleteTransaction(@PathVariable int id) {
        transactionService.deleteTransaction(id);
    }

    @GetMapping("/reports/type")
    public Map<TransactionType, List<Transaction>> getTransactionType() {
        return transactionService.getTransactionType();
    }

    @GetMapping("/reports/product")
    public Map<String, List<Transaction>> getTransactionProduct() {
        return transactionService.getTransactionProduct();
    }
}
