package com.gersgarage.controllers;


import com.gersgarage.models.Product;
import com.gersgarage.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.findAllProducts();
    }

    @GetMapping("product-name/{productName}")
    public List<Product> getProductByName(@PathVariable String productName) {
        return productService.findProductByName(productName);
    }

    @GetMapping("product-name/{productId}")
    public List<Product> getProductById(@PathVariable Integer productId) {
        return productService.findProductById(productId); }

    @DeleteMapping("/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable Integer productId) {
        productService.deleteProductById(productId);
        return ResponseEntity.ok("Product deleted successfully");
    }

    @DeleteMapping("/{productName}")
    public ResponseEntity<String> deleteProduct(@PathVariable String productName) {
        productService.deleteProductByName(productName);
        return ResponseEntity.ok("Product deleted successfully");
    }

    @PutMapping("/{itemId}")
    public ResponseEntity<String> updateProduct(@PathVariable Integer itemId, @RequestBody Product updatedProduct) {
        boolean updated = productService.updateProduct(itemId, updatedProduct);

        if (updated) {
            return ResponseEntity.ok("Product updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
