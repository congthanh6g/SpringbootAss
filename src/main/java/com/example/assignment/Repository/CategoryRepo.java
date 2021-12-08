package com.example.assignment.Repository;


import com.example.assignment.Entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<CategoryEntity , Integer> {
}
