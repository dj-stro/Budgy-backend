package za.dj.budgy.controller;

import org.springframework.web.bind.annotation.*;
import za.dj.budgy.model.Transaction;
import za.dj.budgy.service.TransactionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transactions")
@CrossOrigin(origins = "*")
public class TransactionController {
    private final TransactionService txnService;

    public TransactionController(TransactionService txnService) {
        this.txnService = txnService;
    }

    @GetMapping
    public List<Transaction> getAll(){
        return txnService.getAll();
    }

    @GetMapping("/{id}")
    public Transaction getById(@PathVariable Long id){
        return txnService.findById(id).orElse(null);
    }

    @GetMapping("/users")
    public List<Transaction> getTransactionsByUserIsIn(@RequestParam List<Long> userIds) {
        return txnService.findByUserIdIn(userIds);
    }

    @GetMapping("/user/{userId}")
    public List<Transaction> getTransactionsByUserId(@PathVariable Long userId) {
        return txnService.findByUserId(userId);
    }


    @PostMapping
    public Transaction create(@RequestBody Transaction transaction){
        return txnService.save(transaction);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        txnService.delete(id);
    }
}
