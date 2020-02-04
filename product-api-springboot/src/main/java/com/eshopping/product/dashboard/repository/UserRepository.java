package com.eshopping.product.dashboard.repository;

import com.eshopping.product.dashboard.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
