package com.eshopping.product.dashboard.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eshopping.product.dashboard.model.Product;
import com.eshopping.product.dashboard.service.ProductService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/products")
@ApiResponses(value = {
        @ApiResponse(code = 400, message = "This is bad request, please follow the API documentation for proper request"),
        @ApiResponse(code = 401, message = "Due to security constraint, your access request cannot be authorized"),
        @ApiResponse(code = 500, message = "Server is down, please make sure that Dog microservice is running")
})
@CrossOrigin//(origins = "http://localhost:4200")
public class ProductsController {
    private final ProductService productService;
    private final ProductResourceAssembler assembler;

    public ProductsController(ProductService productService, ProductResourceAssembler assembler) {
        this.productService = productService;
        this.assembler = assembler;
    }

    /**
     * It will list down the all the products
     */
    @GetMapping
    public Iterable<Product> getAllTheProducts() {
    	
        return productService.findAllProducts();
    }

    /**
     * Gets information of a specific product by ID.
     *
     * @param id is the id number for the given product
     * @return all the information of the product
     */
    @GetMapping("/{id}")
    public Product get(@PathVariable Long id) {
        Product product = productService.getProduct(id);
        return product;
    }

    /**
     * Posts Information to create a new product into the system.
     *
     * @param product A new product to add to the system
     * @return response that new product was added to the system.
     */

    @PostMapping
    public ResponseEntity<?> post(@Valid @RequestBody Product product) {
        Product newProduct = productService.save(product);
        Resource<Product> resource = assembler.toResource(newProduct);
        return ResponseEntity.status(HttpStatus.CREATED).body(resource);
    }

    /**
     * Updates the information of product in the system.
     *
     * @param id   The ID number for which the product information gets updated
     * @param json The json string which contains all the information which is to be updated in the system.
     * @return response that vehicle was updated in the system.
     * @throws IOException
     */
    @PutMapping("/{id}")
    ResponseEntity<?> put(@PathVariable Long id, @Valid @RequestBody String json) throws IOException {
        Product newProduct = productService.productUpdate(id, json);
        Resource<Product> resource = assembler.toResource(newProduct);
        return ResponseEntity.ok(resource);
    }

    /**
     * Gets the information based on category
     *
     * @param category the category which applies to all the products in the system
     * @return all the information of the product based on category
     */

    @GetMapping(params = "category")
    public Iterable<Product> getProductsByCategory(@RequestParam(name = "category") String category) {
        return productService.findProductsByCategory(category);
    }

    /**
     * Gets the information based on category and availability
     *
     * @param category     the category which applies to specific products in the system which uses that particular category
     * @param availability the availability which which applies to specific products in the system which uses that particular availability
     * @return all the information of the product based on category and availability.
     */
    @GetMapping(params = {"category", "availability"})
    public List<Product> getProductsByCategoryAndAvailbility(@RequestParam(name = "category") String category, @RequestParam(name = "availability") int availability) {
        boolean available;
        String cat = category.replaceAll("%20", " ");
        available = availability == 1;
        return productService.findProductsByCategoryAndAvailability(cat, available);
    }

    @DeleteMapping("/{id}")
    public Iterable<Product> deleteProductById(@PathVariable Long id){
        return productService.deleteProductById(id);
    }

}
