package com.pplong.fileserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String  hello() {
        return "hello";
    }

    @GetMapping("/test")
    public String test(Model model) {
        model.addAttribute("msg","图片");
        return "test";
    }

}
