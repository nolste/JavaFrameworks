package com.example.demo.repositories;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 *
 *
 *
 *
 */
//This showcases the repository connection to the database with custom SQL query.
//crud repository handles thee add, modify, and delete functions

public interface PartRepository extends CrudRepository <Part,Long> {
    //the question mark in this is a parameterized query. This parameterized query prevents SQL injections
    @Query("SELECT p FROM Part p WHERE p.name LIKE %?1%")
    public List<Part> search(String keyword);
}
