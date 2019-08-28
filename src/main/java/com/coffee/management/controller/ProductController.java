package com.coffee.management.controller;

import com.coffee.management.entity.Product;
import com.coffee.management.service.ProductService;
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
 * Created on 19/08/2019.
 * Class: ProductController.java
 */
@CrossOrigin
@RestController
@RequestMapping("api/admin/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity<Product> createNewProduct (@Valid @RequestBody Product product){
        Product persistedProduct = productService.createNewProduct(product);
        return new ResponseEntity<>(persistedProduct, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProduct(){
        List<Product> products = productService.getAllProduct();
        if (CollectionUtils.isEmpty(products)){
            throw new EntityNotFoundException();
        }
        return new ResponseEntity<>(products,HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable long id){
        Product product = productService.getProduct(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Product> updateProduct(@Valid @RequestBody Product product, @PathVariable long id){
        productService.updateProduct(product,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable long id){
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
