package com.example.shopapi.service;

import com.example.shopapi.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {
    void add(Product product);
    void deleteProduct(Long id);

    void updateProduct(Long id, Product product);

    List<Product> getAllProducts();
    Product getProductById(Long id);

}
