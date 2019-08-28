package com.coffee.management.impl;

import com.coffee.management.entity.Product;
import com.coffee.management.repository.ProductRepository;
import com.coffee.management.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Author: TiDi
 * Created on 19/08/2019.
 * Class: ProductImplement.java
 */
@Service
@Transactional
public class ProductImplement implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public Product createNewProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(long id) {
        return productRepository.getOne(id);
    }

    @Override
    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void updateProduct(Product newProduct, long id) {
        productRepository.findById(id).map(products -> {
            products.setPro_name(newProduct.getPro_name());
            products.setPro_price_s(newProduct.getPro_price_s());
            products.setPro_price_m(newProduct.getPro_price_m());
            products.setPro_price_l(newProduct.getPro_price_l());
            products.setPro_image(newProduct.getPro_image());
            products.setPro_description(newProduct.getPro_description());
            products.setPro_bestseller(newProduct.getPro_bestseller());
            products.setCat_id(newProduct.getCat_id());
            return  productRepository.save(newProduct);
        });
    }
}
