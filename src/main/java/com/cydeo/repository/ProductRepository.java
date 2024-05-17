package com.cydeo.repository;

import com.cydeo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface ProductRepository extends JpaRepository<Product, Long> {

    //Write a derived query to get product by specific name
    Product getProductByName(String name);

    //Write a derived query to get the count of products that have a price greater than specific amount
    Integer countByPriceGreaterThan(BigDecimal amount);
}
