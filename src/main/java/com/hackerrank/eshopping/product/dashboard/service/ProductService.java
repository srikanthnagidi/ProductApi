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

@Service
public class ProductService {
    @Autowired
    private final ProductRepository productRepository;


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProduct(Long id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()){
            Product product = optionalProduct.get();
            return product;
        }else{
            throw new ProductNotFoundException("Product Not Found");
        }
    }
    public Product save (Product product){
        Optional<Product> optionalProduct = productRepository.findById(product.getId());
        if(optionalProduct.isPresent()){
            throw new ProductBadRequestException("Product already exists");
        }

        return productRepository.save(product);

    }

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

    public Iterable<Product> findAllProducts(){
        return productRepository.findAll();
    }

    public Iterable<Product> findProductsByCategory(String category){
        List<Product> product = (List<Product>) productRepository.findAllByCategory(category);
        return product.stream().sorted(Comparator.comparing(Product::getAvailability,Comparator.reverseOrder()).thenComparing(Product::getDiscountedPrice).thenComparing(Product::getId)).collect(Collectors.toList());
    }

    public List<Product> findProductsByCategoryAndAvailability(String category, boolean availability){
        List<Product> products = productRepository.findAllByCategoryAndAvailability(category, availability);
        //System.out.println(products.toString());
       //System.out.println(products.stream().flatMapToLong(x-> ((x.getRetailPrice()-x.getDiscountedPrice())/x.getRetailPrice())*100).collect(Collectors.toList()));
        Comparator<Product> productSort = new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {

                float pr1 = getDiscountPercentge(o1.getRetailPrice(),o1.getDiscountedPrice());
                float pr2 = getDiscountPercentge(o2.getRetailPrice(),o2.getDiscountedPrice());
                if((pr1- pr2) ==0){
                        if(o1.getDiscountedPrice()-o2.getDiscountedPrice()== 0){
                            return o1.getId().compareTo(o2.getId());
                        }else if(o1.getDiscountedPrice()< o2.getDiscountedPrice()){
                            return -1;
                        }else{
                            return 1;
                        }

                }else if( pr1< pr2)
                    {
                    return 1;
                }else{
                    return -1;
                }
            }
        };
        Collections.sort(products,productSort);
        System.out.println(products.toString());
       return products;

    }

    private float getDiscountPercentge(double retailprice, double discountedPrice){
       double number =(((retailprice- discountedPrice)/retailprice) * 100);
       return (float)number;
    }


}
