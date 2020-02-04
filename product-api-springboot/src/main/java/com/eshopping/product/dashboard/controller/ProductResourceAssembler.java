package com.eshopping.product.dashboard.controller;

import com.eshopping.product.dashboard.model.Product;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

/**
 * Maps the ProductsController to the Product class using HATEOS
 */

@Component
public class ProductResourceAssembler implements ResourceAssembler<Product, Resource<Product>> {

    @Override
    public Resource<Product> toResource(Product product) {
        return new Resource<Product>(product);
    }
}
