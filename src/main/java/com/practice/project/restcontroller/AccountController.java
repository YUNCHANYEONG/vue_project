package com.practice.project.restcontroller;

import com.practice.project.form.LoginForm;
import com.practice.project.jwt.JwtToken;
import com.practice.project.security.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "account")
public class AccountController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping("sign-in")
    @ResponseBody
    public JwtToken signIn(@RequestBody LoginForm loginForm){
        String email = loginForm.getEmail();
        String password = loginForm.getPassword();

        JwtToken jwtToken = userService.signIn(email, password);

        return jwtToken;
    }

    @PostMapping("sign-up")
    @ResponseBody
    public String signUp(){
        return "test";
    }
}
