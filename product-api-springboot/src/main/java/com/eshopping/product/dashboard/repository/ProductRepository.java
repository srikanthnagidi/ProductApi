package com.eshopping.product.dashboard.repository;

import com.eshopping.product.dashboard.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    @Override
    Iterable<Product> findAll();

    Iterable<Product> findAllByCategory(String category);

    List<Product> findAllByCategoryAndAvailability(String category, boolean availability);


}
