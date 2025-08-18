package za.dj.budgy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.dj.budgy.model.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Long> {
}
