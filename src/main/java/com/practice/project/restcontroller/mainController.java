package com.practice.project.restcontroller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "main")
public class mainController {

    @PostMapping("list")
    @ResponseBody
    public String List(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication.getName() == null) {
            throw new RuntimeException("No authentication information.");
        }

        String email = authentication.getName();

        return email;
    }

    @PostMapping("listtest")
    @ResponseBody
    public String ListTest(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication.getName() == null) {
            throw new RuntimeException("No authentication information.");
        }

        String email = authentication.getName();

        return email;
    }
}
