package com.poly.lab5.controller;

import com.poly.lab5.service.AccoutService;
import com.poly.lab5.service.CookieService;
import com.poly.lab5.service.ParamService;
import com.poly.lab5.service.ShoppingCartService;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountController {


    @Autowired
    AccoutService accoutService;
    @Autowired
    CookieService cookieService;
    @Autowired
    ParamService paramService;
    @Autowired
    ShoppingCartService cartService;
    @Autowired
    ServletContext app;
    @Autowired
    HttpSession session;

    @GetMapping("/account/login")
    public String login1(Model model) {
        return "/login/login";
    }

    @PostMapping("/account/login")
    public String login2(Model model, @RequestParam("username") String un, @RequestParam("password") String pw) {

        if (un.equals("huy") && pw.equals("1234")) {
            session.setAttribute("username", un);
            return "redirect:/home/trangchu";
        } else if (un.equals("adim") && pw.equals("1234")){
            return "redirect:/admin";
        }else{
            System.out.println("Dang nhap that bai");
            return "/login/login";
        }
    }
}



