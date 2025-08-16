package za.dj.budgy.service.impl;

import org.springframework.stereotype.Service;
import za.dj.budgy.model.Account;
import za.dj.budgy.repository.AccountRepository;
import za.dj.budgy.service.AccountService;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Optional<Account> findById(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public List<Account> findByUserId(Long userId) {
        return accountRepository.findByUserId(userId);
    }

    @Override
    public Optional<Account> findByUserIdIn(List<Long> userIds) {
        return accountRepository.findByUserIdIn(userIds);
    }

    @Override
    public void delete(Long id){
        accountRepository.deleteById(id);
    }
}
