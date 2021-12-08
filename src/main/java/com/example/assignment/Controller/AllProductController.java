package com.example.assignment.Controller;

import com.example.assignment.Entity.ProductEntity;
import com.example.assignment.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class AllProductController {

    @Autowired
    ProductService productService;

    @GetMapping({"/allproduct" , "/allproduct/page/allproduct"})
    private String allproduct(Model model)
    {
          return listByPageAll(model,1);
    }


    @GetMapping("/allproduct/page/{pageNumber}")
    public String listByPageAll(Model model , @PathVariable("pageNumber") int currentPage)
    {
        Page<ProductEntity> page = productService.getAllProduct(currentPage);
        long totalItems = page.getTotalElements();
        int totalPages = page.getTotalPages();
        List<ProductEntity> products = page.getContent();
        model.addAttribute("currentPage" , currentPage);
        model.addAttribute("totalItems",totalItems);
        model.addAttribute("totalPages",totalPages);
        model.addAttribute("products" , products);
        return "allproduct";
    }


}
