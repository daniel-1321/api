package com.coffee.management.service;

import com.coffee.management.entity.Product;

import java.util.List;

public interface ProductService {
    Product createNewProduct(Product product);
    List<Product> getAllProduct();

    Product getProduct(long id);

    void deleteProduct(long id);

    void updateProduct(Product newProduct, long id);
}
