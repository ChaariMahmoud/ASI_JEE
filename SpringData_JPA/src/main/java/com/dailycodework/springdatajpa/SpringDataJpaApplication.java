package com.dailycodework.springdatajpa;

import com.dailycodework.springdatajpa.Entities.Product;
import com.dailycodework.springdatajpa.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner {
    @Autowired
    public ProductRepository productRepository ;
    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        productRepository.save(new Product(null,"Computer",4300,3));
        productRepository.save(new Product(null,"Printer",1200,4));
        productRepository.save(new Product(null,"Smart Phone",3200,32));
        List<Product>products= productRepository.findAll();
        products.forEach(p->System.out.println(p.toString()));
        Product product=productRepository.findById(Long.valueOf(1)).get();
        System.out.println("***********");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getQuantity());
        System.out.println("***********");
        System.out.println("-----------");
        List<Product>productList =productRepository.findByNameContains("C");
        productList.forEach(p ->{
            System.out.println(p.toString());
        } );

        System.out.println("------------");
        List<Product>productList2 =productRepository.search("%C%");
        productList2.forEach(System.out::println);

        System.out.println("------------");
        List<Product>productList3 =productRepository.findByPriceGreaterThan(2);
        productList3.forEach(System.out::println);

        System.out.println("------------");
        List<Product>productList4 =productRepository.findByPriceGreaterThan(2);
        productList4.forEach(System.out::println);
    }

}

