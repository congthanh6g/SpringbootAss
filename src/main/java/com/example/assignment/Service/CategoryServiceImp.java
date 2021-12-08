package com.example.assignment.Service;

import com.example.assignment.Entity.CategoryEntity;
import com.example.assignment.Entity.ProductEntity;
import com.example.assignment.Repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImp implements CategoryService {

    @Autowired
    CategoryRepo categoryRepo;


    @Override
    public Page<CategoryEntity> getAllCategory(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber - 1 , 5);
        return categoryRepo.findAll(pageable);
    }

    @Override
    public CategoryEntity saveCategory(CategoryEntity categoryEntity) {
        return categoryRepo.save(categoryEntity);
    }

    @Override
    public CategoryEntity updateCategory(CategoryEntity categoryEntity) {
        return categoryRepo.save(categoryEntity);
    }

    @Override
    public void deleteCategory(int id) {
         categoryRepo.deleteById(id);
    }

    @Override
    public CategoryEntity getCategoryById(int id) {
        Optional<CategoryEntity> optional = categoryRepo.findById(id);
        CategoryEntity categoryEntity = null;
        if (optional.isPresent())
        {
            categoryEntity = optional.get();
        }else
        {
            throw new RuntimeException("Employee not found for id ::" + id);
        }
        return categoryEntity;
    }
}
