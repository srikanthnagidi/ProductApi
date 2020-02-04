package com.eshopping.product.dashboard.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;

/**
 * Declares the product class , related variables and methods.
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Product {
    @Id
    private Long id;

    private String name;
    private String category;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", retailPrice=" + retailPrice +
                ", discountedPrice=" + discountedPrice +
                ", availability=" + availability +
                '}';
    }

    @JsonProperty(value = "retail_price")
    private Double retailPrice;

    @JsonProperty(value = "discounted_price")
    private Double discountedPrice;

    @Column(name = "availability", columnDefinition = "BOOLEAN")
    private boolean availability;

    public Product() {
    }

    public Product(Long id, String name, String category, Double retailPrice, Double discountedPrice, boolean availability) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.retailPrice = retailPrice;
        this.discountedPrice = discountedPrice;
        this.availability = availability;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(Double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public Double getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(Double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public boolean getAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    /**
     * It calculates the discount percentage
     *
     * @returns the discount percentage.
     */
    public float discountPercentge() {
        double number = (((retailPrice - discountedPrice) / retailPrice) * 100);
        return (float) number;
    }
}
