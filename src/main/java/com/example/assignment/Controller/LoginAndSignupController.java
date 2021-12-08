package com.example.assignment.Controller;

import com.example.assignment.Entity.UserEntity;
import com.example.assignment.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Objects;

@Controller
public class LoginAndSignupController {
    @Autowired
    UserService userService;

    @GetMapping({"/Login" , "/allproduct/page/Login"})
    public String Login(Model model)
    {

        return "Login";
    }

    @GetMapping({"/Signup" , "/allproduct/page/Signup"})
    public String Signup(Model model)
    {
        UserEntity user = new UserEntity();
        model.addAttribute("user" , user);
        return "Signup";
    }

    @PostMapping({"/Login"})
    public String Login(@ModelAttribute("user") UserEntity userEntity , Model model )
    {
          UserEntity oathUser = userService.loginuser(userEntity.getUsername() , userEntity.getPassword());

          if (Objects.nonNull(oathUser))
          {
              if (userEntity.getUsername().equalsIgnoreCase("thanh") && userEntity.getPassword().equalsIgnoreCase("123456")){
                  return "redirect:/admin";
              }
              else
              {
                  return "redirect:/index";
              }
          }
          else
          {
              return "Login";
          }
    }


    @PostMapping("/Signup")
    public String Signup(Model model, @ModelAttribute("user") UserEntity userEntity) {
        String mes;
        if(userService.userExists(userEntity.getUsername()))
        {
        if (userEntity.getUsername().length() > 3 && userEntity.getPassword().length() > 5) {
            userService.saveuser(userEntity);
            return "redirect:/Login";
        }
        else
        {
            model.addAttribute("mes" , "Username > 3 && Password > 5");
            return "Signup";
        }
        }
        else
        {
            model.addAttribute("mes" , "Account already exists");
            return "Signup";
        }
    }

}
