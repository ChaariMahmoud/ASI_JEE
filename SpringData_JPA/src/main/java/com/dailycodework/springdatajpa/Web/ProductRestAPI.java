package com.dailycodework.springdatajpa.Web;

import com.dailycodework.springdatajpa.Entities.Product;
import com.dailycodework.springdatajpa.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductRestAPI {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> products(){
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    public Product findProducts(@PathVariable long id){
        return productRepository.findById(id).orElse(null);
    }
}
