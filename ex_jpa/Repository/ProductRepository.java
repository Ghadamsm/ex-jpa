package com.example.ex_jpa.Repository;

import com.example.ex_jpa.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
