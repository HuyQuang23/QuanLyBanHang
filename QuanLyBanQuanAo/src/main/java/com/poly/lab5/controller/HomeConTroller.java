package com.poly.lab5.controller;

import com.poly.lab5.dao.CategoryDAO;
import com.poly.lab5.dao.ProductDAO;
import com.poly.lab5.entity.Category;
import com.poly.lab5.entity.Product;
import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/home")


public class HomeConTroller {

    @Autowired
    ServletContext app;
    @Autowired
    ProductDAO dao;
    @Autowired
    CategoryDAO daocategory;

    @GetMapping("/trangchu")
    public String index(Model model,
                        @RequestParam("p") Optional<Integer> p) {
        Pageable pageable = PageRequest.of(p.orElse(0), 5);
        Page<Product> items = dao.findAll(pageable);
        model.addAttribute("items", items);
        return "Home/home";
    }

}
