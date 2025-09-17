package za.dj.budgy.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import za.dj.budgy.model.Account;
import za.dj.budgy.model.Transaction;
import za.dj.budgy.model.enums.TransactionType;
import za.dj.budgy.repository.AccountRepository;
import za.dj.budgy.repository.TransactionRepository;
import za.dj.budgy.service.TransactionService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository txnRepository;
    private final AccountRepository accountRepository;

    public TransactionServiceImpl(TransactionRepository txnRepository, AccountRepository accountRepository) {
        this.txnRepository = txnRepository;
        this.accountRepository = accountRepository;
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
    public List<Transaction> findByUserIdIn(List<Long> userIds) {
        return txnRepository.findByUserIdIn(userIds);
    }

    @Override
    public Optional<Transaction> findById(Long id) {
        return txnRepository.findById(id);
    }

    @Override
    @Transactional
    public Transaction save(Transaction transaction) {
        // Handle debit (accountFrom)
        if (transaction.getAccountFrom() != null) {
            Account from = accountRepository.findById(transaction.getAccountFrom().getId())
                    .orElseThrow(() -> new IllegalArgumentException("AccountFrom not found"));

            handleDebit(transaction, from);
            accountRepository.save(from);
        }

        // Handle credit (accountTo)
        if (transaction.getAccountTo() != null) {
            Account to = accountRepository.findById(transaction.getAccountTo().getId())
                    .orElseThrow(() -> new IllegalArgumentException("AccountTo not found"));

            handleCredit(transaction, to);
            accountRepository.save(to);
        }

        return txnRepository.save(transaction);
    }

    private void handleDebit(Transaction transaction, Account from) {
        BigDecimal amount = transaction.getAmount();

        switch (transaction.getType()) {
            case EXPENSE -> {
                validateSufficientFunds(from, amount, "Expense");
                from.setBalance(from.getBalance().subtract(amount));
                from.setBudgetBalance(from.getBudgetBalance().subtract(amount));
            }
            case TRANSFER -> {
                validateSufficientFunds(from, amount, "Transfer");
                from.setBalance(from.getBalance().subtract(amount));
            }
            default -> {
                // Do nothing for INCOME (only credits)
            }
        }
    }

    private void handleCredit(Transaction transaction, Account to) {
        BigDecimal amount = transaction.getAmount();

        switch (transaction.getType()) {
            case INCOME -> to.setBalance(to.getBalance().add(amount));
            case TRANSFER -> to.setBalance(to.getBalance().add(amount));
            default -> {
                // Do nothing for EXPENSE (only debits)
            }
        }
    }

    private void validateSufficientFunds(Account account, BigDecimal amount, String context) {
        if (amount.compareTo(account.getBalance()) >= 0) {
            throw new IllegalStateException(
                    context + " blocked: amount (" + amount +
                            ") is greater than or equal to account balance (" + account.getBalance() +
                            ") for account ID " + account.getId()
            );
        }
    }

    @Override
    public void delete(Long id) {
        txnRepository.deleteById(id);
    }
}
