package za.dj.budgy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.dj.budgy.model.Category;

public interface CategoriesRepository extends JpaRepository<Category, Long> {
}
