package com.example.assignment.Service;

import com.example.assignment.Entity.CategoryEntity;
import org.springframework.data.domain.Page;

public interface CategoryService {
    Page<CategoryEntity> getAllCategory(int pageNumber);
    CategoryEntity saveCategory(CategoryEntity categoryEntity);
    CategoryEntity updateCategory(CategoryEntity categoryEntity);
    void deleteCategory(int id);
    CategoryEntity getCategoryById(int id);
}
