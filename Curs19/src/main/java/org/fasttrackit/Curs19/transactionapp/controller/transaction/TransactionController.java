package org.fasttrackit.Curs19.transactionapp.controller.transaction;

import lombok.RequiredArgsConstructor;
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
    List<Transaction> getAll(@RequestParam(required = false) String product, @RequestParam(required = false) String type, @RequestParam(required = false) Double minAmount, @RequestParam(required = false) Double maxAmount, HttpServletRequest request) {
        if (request.getParameter("product") != null) {
            return transactionService.findByProduct(product);
        } else if (request.getParameter("type") != null) {
            if (request.getParameter("minAmount") == null & request.getParameter("maxAmount") == null) {
                return transactionService.findByType(type);
            } else if (request.getParameter("minAmount") != null & request.getParameter("maxAmount") == null) {
                return transactionService.findByTypeAndAmountGreaterThan(type, minAmount);
            } else if (request.getParameter("minAmount") == null) {
                return transactionService.findByTypeAndAmountLessThan(type, maxAmount);
            } else {
                return transactionService.findByTypeAmountBetween(type, minAmount, maxAmount);
            }
        } else if (request.getParameter("type") == null) {
            if (request.getParameter("minAmount") != null & request.getParameter("maxAmount") == null) {
                return transactionService.findByAmountGreaterThan(minAmount);
            } else if(request.getParameter("minAmount") == null & request.getParameter("maxAmount") != null){
                return transactionService.findByAmountLessThan(maxAmount);
            } else if (request.getParameter("minAmount") != null & request.getParameter("maxAmount") != null){
                return transactionService.findByAmountBetween(minAmount, maxAmount);
            }
        }
        return transactionService.getAll();
    }


    /*List<Transaction> getAll(@RequestParam(required = false) String filterType, @RequestParam(required = false) String value, HttpServletRequest request) {
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
    }*/

    @GetMapping("{id}")
    public Transaction getById(@PathVariable int id) {
        return transactionService.findById(id);
    }

    @PostMapping
    public void saveTransaction(@RequestBody Transaction transaction) {
        transactionService.save(transaction);
    }

    @PutMapping("{id}")
    public void replaceTransaction(@PathVariable int id, @RequestBody Transaction transaction){
        transaction.setId(id);
        transactionService.save(transaction);
    }


    @PatchMapping("{id}")
    public void replaceChangeTransaction(@PathVariable int id, @RequestParam(required = false) String product, @RequestParam(required = false) double amount) {
        transactionService.patch(id, product, amount);
    }

    @DeleteMapping("{id}")
    public void deleteTransaction(@PathVariable int id) {
        transactionService.delete(id);
    }

    @GetMapping("/reports/type")
    public Map<TransactionType, Double> getSumOfTransactionTypes(){
        return transactionService.getTransactionTypeTotalSum();
    }

    @GetMapping("reports/product")
    public Map<String, Double> getSumOfProducts(){
        return transactionService.getProductTotalSum();
    }

    @GetMapping("/reports/typeMapped")
    public Map<TransactionType, List<Transaction>> getTransactionType() {
        return transactionService.getTransactionGroupedByType();
    }


    @GetMapping("/reports/productMapped")
    public Map<String, List<Transaction>> getTransactionProduct() {
        return transactionService.getTransactionGroupedByProduct();
    }
}
