package com.example.demo.domain;


import com.example.demo.validators.ValidMinMaxPartInventory;

import javax.persistence.*;
import javax.validation.constraints.Max;
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

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="part_type",discriminatorType = DiscriminatorType.INTEGER)
@Table(name="Parts")
@ValidMinMaxPartInventory
public abstract class Part implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String name;
    @Min(value = 0, message = "Price value must be positive")
    double price;
    @Min(value = 0, message = "Inventory value must be positive")
    //@Max(value = 9000, message = "It's Over 9000!!!!")
    Integer inv;


    @Min(value = 1, message = "Inventory must be greater than 0")
    Integer minInventory;
    @Max(value = 9000, message = "It is over 9000!!!")
    Integer maxInventory;

    LocalDate dateAdded;



    @ManyToMany
    @JoinTable(name="product_part", joinColumns = @JoinColumn(name="part_id"),
            inverseJoinColumns=@JoinColumn(name="product_id"))
    Set<Product> products= new HashSet<>();

    public Part() {
    }

    public Part(long id, String name, double price, int inv, int minInventory) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.inv = inv;
        //this.minInventory = minInventory;


    }

    public Part(long id, String name, double price, int inv, Integer minInventory, Integer maxInventory,LocalDate dateAdded) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.inv = inv;
        this.minInventory = minInventory;
        this.maxInventory = maxInventory;
        this.dateAdded = dateAdded;
    }

    public Part(String name, double price, int inv) {
        this.name = name;
        this.price = price;
        this.inv = inv;
    }

    public Part(long id, String name, double price, int inv) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.inv = inv;
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

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public String toString(){
        return this.name;
    }

    public Integer getMinInventory() {
        return minInventory;
    }

    public void setMinInventory(Integer minInventory) {
        this.minInventory = minInventory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Part part = (Part) o;

        return id == part.id;
    }

    public Integer getMaxInventory() {
        return maxInventory;
    }

    public void setMaxInventory(Integer maxInventory) {
        this.maxInventory = maxInventory;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
