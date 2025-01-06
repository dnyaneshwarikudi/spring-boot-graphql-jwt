package com.example.demo.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@Controller
public class ProductGraphQLController {
	
	private final ProductService service;

    public ProductGraphQLController(ProductService service) {
        this.service = service;
    }
    
    @QueryMapping
    public List<Product> products() {
        return service.getAllProducts();
    }

    @QueryMapping
    public Product product(@Argument Long id) {
        return service.getProductById(id);
    }
    @MutationMapping
    public Product createProduct(@Argument String name, @Argument Double price, @Argument String description) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setDescription(description);
        return service.createProduct(product);
    }

    @MutationMapping
    public Product updateProduct(@Argument Long id, @Argument String name, @Argument Double price, @Argument String description) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setDescription(description);
        return service.updateProduct(id, product);
    }

    @MutationMapping
    public String deleteProduct(@Argument Long id) {
        service.deleteProduct(id);
        return "Product deleted";
    }

}
