package com.hackerrank.eshopping.product.dashboard.repository;

import com.hackerrank.eshopping.product.dashboard.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    @Override
    Iterable<Product> findAll();
    Iterable<Product> findAllByCategory(String category);
    List<Product> findAllByCategoryAndAvailability(String category, boolean availability);


}
