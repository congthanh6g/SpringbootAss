package com.example.assignment.Service;

import com.example.assignment.Entity.ProductEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    Page<ProductEntity> getAllProduct(int pageNumber);
    ProductEntity saveProduct(ProductEntity productEntity);
    ProductEntity updateProduct(ProductEntity productEntity);
    void deleteProduct(int id);
    ProductEntity getProductById(int id);
}
