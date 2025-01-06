package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {

	 private final ProductRepository repository;

	    public ProductService(ProductRepository repository) {
	        this.repository = repository;
	    }

	    public List<Product> getAllProducts() {
	        return repository.findAll();
	    }
	    
	    public Product getProductById(Long id) {
	        return repository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
	    }

	    public Product createProduct(Product product) {
	        return repository.save(product);
	    }

	    public Product updateProduct(Long id, Product product) {
	        Product existingProduct = getProductById(id);
	        existingProduct.setName(product.getName());
	        existingProduct.setPrice(product.getPrice());
	        existingProduct.setDescription(product.getDescription());
	        return repository.save(existingProduct);
	    }
	    
	    public void deleteProduct(Long id) {
	        repository.deleteById(id);
	    }

}
