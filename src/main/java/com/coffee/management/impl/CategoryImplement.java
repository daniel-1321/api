package com.coffee.management.impl;

import com.coffee.management.entity.Category;
import com.coffee.management.repository.CategoryRepository;
import com.coffee.management.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Author: TiDi
 * Created on 15/08/2019.
 * Class: CategoryImplement.java
 */
@Service
@Transactional
public class CategoryImplement implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category createNewCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategory(long id) {
        return categoryRepository.getOne(id);
    }

    @Override
    public void deleteCategory(long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public void updateCategory(Category newCategory, long id) {
        categoryRepository.findById(id).map(category ->{
            category.setCat_name(newCategory.getCat_name());
            return categoryRepository.save(category);
        });
    }
}
