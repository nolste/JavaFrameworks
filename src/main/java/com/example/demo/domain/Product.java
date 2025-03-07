package com.example.demo.domain;

import com.example.demo.validators.ValidMinMaxInv;
import com.example.demo.validators.ValidEnufParts;
import com.example.demo.validators.ValidProductPrice;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 *
 *
 *
 *
 */
@Entity
@Table(name="Products")
@ValidProductPrice
@ValidEnufParts
@ValidMinMaxInv
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String name;
    @Min(value = 0, message = "Price value must be positive")
    double price;
    @Min(value = 0, message = "Inventory value must be positive")
    Integer inv;
    @ManyToMany(cascade=CascadeType.ALL, mappedBy = "products")
    Set<Part> parts= new HashSet<>();

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    LocalDate dateAdded;

    public Product() {
    }

    public Product(String name, double price, int inv) {
        this.name = name;
        this.price = price;
        this.inv = inv;
    }

    public Product(long id, String name, double price, int inv, LocalDate dateAdded) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.inv = inv;
        this.dateAdded= dateAdded;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getInv() {
        return inv;
    }

    public void setInv(Integer inv) {
        this.inv = inv;
    }

    public Set<Part> getParts() {
        return parts;
    }

    public void setParts(Set<Part> parts) {
        this.parts = parts;
    }

    public String toString(){
        return this.name;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return id == product.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
