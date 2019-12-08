package com.hackerrank.eshopping.product.dashboard.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.BAD_REQUEST, reason = "Bad Request")
public class ProductBadRequestException extends RuntimeException {
    public ProductBadRequestException(String product_not_found) {
        super(product_not_found);
    }
    public ProductBadRequestException(){

    }
}
