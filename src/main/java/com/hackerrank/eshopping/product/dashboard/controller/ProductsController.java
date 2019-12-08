package com.hackerrank.eshopping.product.dashboard.controller;

import com.hackerrank.eshopping.product.dashboard.model.Product;
import com.hackerrank.eshopping.product.dashboard.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductsController {

    private final ProductService productService;
    private final ProductResourceAssembler assembler;

    public ProductsController(ProductService productService, ProductResourceAssembler assembler) {
        this.productService = productService;
        this.assembler = assembler;
    }

    @GetMapping
    public Iterable<Product> getAllTheProducts(){
        return  productService.findAllProducts();
    }

    @GetMapping("/{id}")
    public Resource<Product> get(@PathVariable Long id){
        Product product = productService.getProduct(id);
        return assembler.toResource(product);
    }

    @PostMapping
    public ResponseEntity<?> post(@Valid @RequestBody Product product) throws URISyntaxException{
        Product newProduct = productService.save(product);
        Resource<Product> resource = assembler.toResource(newProduct);
        return ResponseEntity.status(HttpStatus.CREATED).body(resource);
    }

    @PutMapping("/{id}")
    ResponseEntity<?> put(@PathVariable Long id, @Valid @RequestBody String json) throws IOException {
        Product newProduct = productService.productUpdate(id, json);
        Resource<Product> resource = assembler.toResource(newProduct);
        return ResponseEntity.ok(resource);
    }

    @GetMapping(params="category")
    public Iterable<Product> getProductsByCategory(@RequestParam(name = "category") String category){
        return productService.findProductsByCategory(category);
    }

    @GetMapping(params={"category","availability"})
    public List<Product> getProductsByCategoryAndAvailbility(@RequestParam(name = "category") String category, @RequestParam(name = "availability") int availability){
        boolean available;
        String cat = category.replaceAll("%20"," ");

       if(availability == 1){
             available = true;
        }
        else{
             available = false;
        }

        return productService.findProductsByCategoryAndAvailability(cat,available);
    }

}
