package com.example.assignment.Service;


import com.example.assignment.Entity.ProductEntity;
import com.example.assignment.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    ProductRepo productRepo;

    @Override
    public Page<ProductEntity> getAllProduct(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber - 1 , 5);
        return productRepo.findAll(pageable);
    }

    @Override
    public ProductEntity saveProduct(ProductEntity productEntity) {

        return productRepo.save(productEntity);
    }

    @Override
    public ProductEntity updateProduct(ProductEntity productEntity) {

        return productRepo.save(productEntity);
    }

    @Override
    public void deleteProduct(int id) {

        productRepo.deleteById(id);
    }

    @Override
    public ProductEntity getProductById(int id) {
        Optional<ProductEntity> optional = productRepo.findById(id);
        ProductEntity productEntity = null;
        if (optional.isPresent())
        {
            productEntity = optional.get();
        }else
        {
            throw new RuntimeException("Employee not found for id ::" + id);
        }
        return productEntity;
    }


}
