package com.example.assignment.Controller;

import com.example.assignment.Entity.CategoryEntity;
import com.example.assignment.Entity.ProductEntity;
import com.example.assignment.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CategoryAllController {
    @Autowired
    CategoryService categoryService;
    @GetMapping("/categoryall")
    private String admin(Model model)
    {

        return listByPageCategory(model,1);
    }

    @GetMapping("/categoryall/page/{pageNumber}")
    public String listByPageCategory(Model model , @PathVariable("pageNumber") int currentPage)
    {
        Page<CategoryEntity> page = categoryService.getAllCategory(currentPage);
        long totalItems = page.getTotalElements();
        int totalPages = page.getTotalPages();
        List<CategoryEntity> categories = page.getContent();
        model.addAttribute("currentPage" , currentPage);
        model.addAttribute("totalItems",totalItems);
        model.addAttribute("totalPages",totalPages);
        model.addAttribute("categories" , categories);
        return "categoryall";
    }

    @GetMapping("/showFormForCategoryUpdate/{id}")
    private String showFormForUpdate(@PathVariable(value = "id") int id , Model model)
    {
        CategoryEntity categoryEntity = categoryService.getCategoryById(id);

        model.addAttribute("category", categoryEntity);
        return "update_category";
    }

    @GetMapping("/deleteCategory/{id}")
    public String deleteProduct(@PathVariable (value = "id") int id)
    {
        categoryService.deleteCategory(id);
        return "redirect:/categoryall";
    }


    @GetMapping({"/addcategory" , "/categoryall/page/addcategory"})
    private String showCategory(Model model)
    {
        CategoryEntity categoryEntity = new CategoryEntity();
        model.addAttribute("category" , categoryEntity);
        return "addcategory";
    }

    @PostMapping({"/addcategory" , "/categoryall/page/addcategory"})
    private String addCategory(Model model , @ModelAttribute CategoryEntity categoryEntity)
    {
        categoryService.saveCategory(categoryEntity);
        return "redirect:/categoryall";
    }
}
