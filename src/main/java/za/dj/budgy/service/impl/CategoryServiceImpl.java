package za.dj.budgy.service.impl;

import org.springframework.stereotype.Service;
import za.dj.budgy.model.Category;
import za.dj.budgy.repository.CategoriesRepository;
import za.dj.budgy.service.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoriesRepository categoriesRepository;

    public CategoryServiceImpl(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    @Override
    public List<Category> getAll() {
        return categoriesRepository.findAll();
    }

    @Override
    public Category save(Category category) {
        return categoriesRepository.save(category);
    }
}
