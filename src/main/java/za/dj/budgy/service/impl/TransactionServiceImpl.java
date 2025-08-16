package za.dj.budgy.service.impl;

import org.springframework.stereotype.Service;
import za.dj.budgy.model.Transaction;
import za.dj.budgy.repository.TransactionRepository;
import za.dj.budgy.service.TransactionService;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository txnRepository;

    public TransactionServiceImpl(TransactionRepository txnRepository) {
        this.txnRepository = txnRepository;
    }


    @Override
    public List<Transaction> getAll() {
        return txnRepository.findAll();
    }


    @Override
    public List<Transaction> findByUserId(Long userId) {
        return txnRepository.findByUserId(userId);
    }

    @Override
    public Optional<Transaction> findByUserIdIn(List<Long> userIds) {
        return txnRepository.findByUserIdIn(userIds);
    }

    @Override
    public Optional<Transaction> findById(Long id) {
        return txnRepository.findById(id);
    }

    @Override
    public Transaction save(Transaction transaction) {
        return txnRepository.save(transaction);
    }

    @Override
    public void delete(Long id) {
        txnRepository.deleteById(id);
    }
}
