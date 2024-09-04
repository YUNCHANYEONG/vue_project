package com.practice.project.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "")
public class IndexController {

    @RequestMapping("")
    public String Index(){
        return "????";
    }
}
