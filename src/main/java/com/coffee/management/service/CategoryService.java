package com.coffee.management.service;

import com.coffee.management.entity.Category;

import java.util.List;

public interface CategoryService {
    Category createNewCategory (Category category);
    List<Category> getAllCategory();

    Category getCategory(long id);

    void deleteCategory(long id);

    void updateCategory(Category newCategory, long id);
}
