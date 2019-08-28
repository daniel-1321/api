package com.coffee.management.controller;

import com.coffee.management.entity.Category;
import com.coffee.management.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

/**
 * Author: TiDi
 * Created on 16/08/2019.
 * Class: CategoryController.java
 */
@CrossOrigin
@RestController
@RequestMapping("api/admin/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Category> createNewCategory (@Valid @RequestBody Category category){
        Category persistedCategory = categoryService.createNewCategory(category);
        return new ResponseEntity<>(persistedCategory, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Category>> getCategory(){
        List<Category> category = categoryService.getAllCategory();
        if (CollectionUtils.isEmpty(category)){
            throw new EntityNotFoundException();
        }
        return new ResponseEntity<>(category,HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable long id){
        Category category = categoryService.getCategory(id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Category> updateCategory(@Valid @RequestBody Category category, @PathVariable long id){
        categoryService.updateCategory(category,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable long id){
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
