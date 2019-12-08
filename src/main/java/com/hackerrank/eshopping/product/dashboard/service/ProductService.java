package com.hackerrank.eshopping.product.dashboard.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackerrank.eshopping.product.dashboard.model.Product;
import com.hackerrank.eshopping.product.dashboard.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * The product service which creates, reads, update the information about the products.
 */
@Service
public class ProductService {
    @Autowired
    private final ProductRepository productRepository;


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Get a product information based on id (or throws exception if non-existent)
     * @param id the ID number of the product to gather information.
     * @return the requested product information
     */
    public Product getProduct(Long id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()){
            Product product = optionalProduct.get();
            return product;
        }else{
            throw new ProductNotFoundException("Product Not Found");
        }
    }

    /**
     * Creates a product based on prior existense of the product
     * @param product A product object which can be either new or existing
     * @return the new product is stored in the repository
     */
    public Product save (Product product){
        Optional<Product> optionalProduct = productRepository.findById(product.getId());
        if(optionalProduct.isPresent()){
            throw new ProductBadRequestException("Product already exists");
        }
        return productRepository.save(product);
    }

    /**
     * Updates the product information based on id which updates the provided information in the string
     * @param id  the ID number of the product to gather information.
     * @param json the string which contains the details which are to be updated
     * @return the updated product is stored in the repository
     * @throws IOException
     */
    public Product productUpdate(Long id, String json) throws IOException {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> map = objectMapper.readValue(json, new TypeReference<Map<String, Object>>() {
            });
            product.setRetailPrice((double) map.get("retail_price"));
            product.setDiscountedPrice((double) map.get("discounted_price"));
            product.setAvailability((boolean) map.get("availability"));

            return productRepository.save(product);
        }
        else{
            throw new ProductBadRequestException("id not found");
        }
    }

    /**
     * Gathers  information of all the products
     * @return all the products in the product repository.
     */
    public Iterable<Product> findAllProducts(){
        return productRepository.findAll();
    }

    /**
     * Gathers the information based on category
     * @param category the category of the product to gather the information
     * @returns the product based on availability and if the availability status is same
     * then it is sorted based on the discounted price in the ascending order. Also, if the products have
     * the same discounted price it should be sorted based on ID in the ascending order.
     */
    public Iterable<Product> findProductsByCategory(String category){
        List<Product> product = (List<Product>) productRepository.findAllByCategory(category);
        return product.stream().sorted(Comparator.comparing(Product::getAvailability,Comparator.reverseOrder())
                .thenComparing(Product::getDiscountedPrice)
                .thenComparing(Product::getId))
                .collect(Collectors.toList());
    }

    /**
     * Gathers information of the product based on category and availability
     * @param category the category of the product to gather the information.
     * @param availability the availability of the product
     * @returns the product information based on first calculating the discount percentage and sorting in the descending order
     * If the product has the same discount percentage then it should be sorted based on the discount price in the ascending order.
     * Also, if the products has the same discount price it should be sorted based on the ID in the ascending order.
     */
    public List<Product> findProductsByCategoryAndAvailability(String category, boolean availability){
        List<Product> products = productRepository.findAllByCategoryAndAvailability(category, availability);

       return products.stream().sorted(Comparator.comparing(Product::discountPercentge,Collections.reverseOrder())
               .thenComparing(Product::getDiscountedPrice)
               .thenComparing(Product::getId))
               .collect(Collectors.toList());
    }
}
