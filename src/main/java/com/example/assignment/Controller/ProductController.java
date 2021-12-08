package com.example.assignment.Controller;

import com.example.assignment.Entity.ProductEntity;
import com.example.assignment.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping({"/addproduct" , "/admin/page/addproduct"})
    private String showaddproduct(Model model)
    {
        ProductEntity product = new ProductEntity();
        model.addAttribute("product" , product);
        return "addproduct";
    }

    @PostMapping({"/addproduct" , "/admin/page/addproduct" })
    private String addproduct(Model model , @ModelAttribute ProductEntity productEntity)
    {
        productService.saveProduct(productEntity);
        return "redirect:/admin";
    }

    @GetMapping("/showFormForUpdate/{id}")
    private String showFormForUpdate(@PathVariable(value = "id") int id , Model model)
    {
        ProductEntity product = productService.getProductById(id);

        model.addAttribute("product", product);
        return "update_product";
    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable (value = "id") int id)
    {
        productService.deleteProduct(id);
        return "redirect:/admin";
    }







}
