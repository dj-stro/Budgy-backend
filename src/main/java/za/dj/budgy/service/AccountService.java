package za.dj.budgy.service;

import za.dj.budgy.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    List<Account> getAll();
    Account save(Account account);
    Optional<Account> findById(Long id);
    List<Account> findByUserId(Long userId);
    Optional<Account> findByUserIdIn(List<Long> userIds);
    void delete(Long id);
}
