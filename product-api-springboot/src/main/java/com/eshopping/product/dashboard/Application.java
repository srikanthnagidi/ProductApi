package com.eshopping.product.dashboard;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.eshopping.product.dashboard.model.Product;
import com.eshopping.product.dashboard.repository.ProductRepository;

@SpringBootApplication(exclude = {SecurityFilterAutoConfiguration.class})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public ApplicationRunner init(ProductRepository productRepository) {
        return args -> {
            Stream.of(new Product(1L, "Dressing Gown", "Full Body Outfits", 303.0, 251.49, true),
                    new Product(2L, "Shoes", "Footwear", 150.0, 123.0, true),
                    new Product(3L, "Nightgown", "Full Body Outfits", 307.0, 254.81, true),
                    new Product(4L, "Boots", "Footwear", 162.0, 132.84, true),
                    new Product(5L, "Ball Gown", "Full Body Outfits", 337.0, 272.97, true),
                    new Product(6L, "Shawl", "Accessories", 283.0, 260.86, true)
            ).forEach(product -> productRepository.save(product));
        };
    }

}
