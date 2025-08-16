package za.dj.budgy.service;

import za.dj.budgy.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();
    Category save(Category category);
}
