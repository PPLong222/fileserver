package com.pplong.fileserver.controller;

import com.pplong.fileserver.Constant;
import com.pplong.fileserver.mapper.SuperAdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private SuperAdminMapper mapper;

    @RequestMapping("/onLogin")
    public String onLogin(String pwd, Model model, HttpSession session) {
        int res = mapper.login(pwd);
        System.out.println(pwd);

        if(res == Constant.RES_OK) {
            session.setAttribute("loginUser",pwd);
            return "redirect:/main";
        }else{
            model.addAttribute("error_msg", Constant.LoginError);
            return Constant.HTMLPage.LoginPage;
        }
    }
}
