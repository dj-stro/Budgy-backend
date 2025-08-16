package za.dj.budgy.service;

import za.dj.budgy.model.Transaction;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface TransactionService {
    List<Transaction> getAll();
    Optional<Transaction> findById(Long id);
    List<Transaction> findByUserId(Long userId);
    Optional<Transaction> findByUserIdIn(List<Long> userIds);
    Transaction save(Transaction transaction);
    void delete(Long id);
}
