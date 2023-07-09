package com.example.shopapi.service;

import com.example.shopapi.config.QueueSender;
import com.example.shopapi.entity.Product;
import com.example.shopapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@EnableCaching
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

    @Autowired
    private QueueSender queueSender;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){
       this.productRepository = productRepository;
    }
    @Override
    public void add(Product product) {
        this.productRepository.save(product);
        queueSender.send(product.getProductName());

    }

    @Override
    public void deleteProduct(Long id) {
        this.productRepository.deleteById(id);
    }

    @Override
    public void updateProduct(Long id, Product product) {
        Optional<Product> result = this.productRepository.findById(id);
        Product _product = result.get();
        _product.setId(product.getId());
        _product.setProductName(product.getProductName());
        this.productRepository.save(_product);
    }

    @Cacheable("products")
    @Override
    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> product = this.productRepository.findById(id);
        return product.get();
    }
}
