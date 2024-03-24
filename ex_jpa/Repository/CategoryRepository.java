package com.example.ex_jpa.Repository;

import com.example.ex_jpa.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
