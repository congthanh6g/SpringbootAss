package com.example.assignment.Controller;


import com.example.assignment.Entity.ProductEntity;
import com.example.assignment.Service.ProductService;
import com.example.assignment.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class WebController {
      @Autowired
      ProductService productService;

      @GetMapping({"/" , "/index" ,"/allproduct/page/index"})
      private String homepage(Model model)
      {
            return listByPage(model,1);
      }

      @GetMapping("/admin")
      private String admin(Model model)
      {

            return listByPageAdmin(model,1);
      }

      @GetMapping("/admin/page/{pageNumber}")
      public String listByPageAdmin(Model model , @PathVariable("pageNumber") int currentPage)
      {
            Page<ProductEntity> page = productService.getAllProduct(currentPage);
            long totalItems = page.getTotalElements();
            int totalPages = page.getTotalPages();
            List<ProductEntity> products = page.getContent();
            model.addAttribute("currentPage" , currentPage);
            model.addAttribute("totalItems",totalItems);
            model.addAttribute("totalPages",totalPages);
            model.addAttribute("products" , products);
            return "admin";
      }

      @GetMapping("/page/{pageNumber}")
      public String listByPage(Model model , @PathVariable("pageNumber") int currentPage)
      {
            Page<ProductEntity> page = productService.getAllProduct(currentPage);
            long totalItems = page.getTotalElements();
            int totalPages = page.getTotalPages();
            List<ProductEntity> products = page.getContent();
            model.addAttribute("currentPage" , currentPage);
            model.addAttribute("totalItems",totalItems);
            model.addAttribute("totalPages",totalPages);
            model.addAttribute("ListP" , products);
            return "index";
      }

}
