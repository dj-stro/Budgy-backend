package za.dj.budgy.controller;

import org.springframework.web.bind.annotation.*;
import za.dj.budgy.model.Category;
import za.dj.budgy.repository.CategoriesRepository;
import za.dj.budgy.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "*")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAllCategories(){
        return categoryService.getAll();
    }

    @PostMapping
    public Category saveCategory(@RequestBody Category category){
        return categoryService.save(category);
    }
}
