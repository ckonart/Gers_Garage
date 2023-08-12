package com.gersgarage.service;

import com.gersgarage.models.Product;
import com.gersgarage.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {this.productRepository = productRepository; }

    public List<Product> findAllProducts() {return productRepository.findAllProducts(); }

    public List<Product> findProductById(Integer productId) {
        return productRepository.findProductById(productId);
    }

    public List<Product> findProductByName(String productName) {
        return productRepository.findProductByName(productName);
    }

    public void deleteProductById(Integer productId) {
        productRepository.deleteProductById(productId); }

    public void deleteProductByName(String productName) {
        productRepository.deleteProductByName(productName); }

    @Transactional
    public boolean updateProduct(Integer itemId, Product updatedProduct) {
        Product existingProduct = productRepository.findById(itemId).orElse(null);

        if (existingProduct != null) {
            existingProduct.setItem_name(updatedProduct.getItem_name());
            existingProduct.setItem_cost(updatedProduct.getItem_cost());

            productRepository.save(existingProduct);
            return true;
        } else {
            return false;
        }
    }

}