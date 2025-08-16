package za.dj.budgy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.dj.budgy.model.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {

    List<Transaction> findByUserId(Long userId);

    Optional<Transaction> findByUserIdIn(List<Long> userIds);

}
