package za.dj.budgy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.dj.budgy.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findByUserId(Long userId);

    Optional<Account> findByUserIdIn(List<Long> userIds);

}
