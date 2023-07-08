package com.poly.lab5.controller;

import com.poly.lab5.dao.CategoryDAO;
import com.poly.lab5.entity.Category;
import com.poly.lab5.entity.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
public class CatecoryCotroller {
    @Autowired
    CategoryDAO daocategory;

    @GetMapping("/catecory/index")
    public String index(Model model,
                        @RequestParam("p") Optional<Integer> p) {
        Pageable pageable = PageRequest.of(p.orElse(0), 5);
        Page<Category> list = daocategory.findAll(pageable);
        model.addAttribute("categoryeis", list);
        return "/Catecory/index";
    }

    @GetMapping("/catecory/create")
    public String view() {
        return "/Catecory/add";
    }

    @PostMapping("/catecory/create")
    public String create(
            @RequestParam("id") String id,
            @RequestParam("name") String name


    ) throws IllegalStateException, IOException {

        Category category1 = new Category();
        category1.setId(id);
        category1.setName(name);
        daocategory.save(category1);

        return "redirect:/catecory/index";
    }

    @GetMapping("/catecory/delete/{id}")
    public String create(@PathVariable("id") String id) {
        daocategory.deleteById(id);
        return "redirect:/Catecory/index";
    }

    @GetMapping("/catecory/update/{id}")
    public String viewupdate(@PathVariable("id") String id, Model model) {
        Category category = daocategory.findById(id).orElse(null);
        model.addAttribute("category", category);
        return "/Catecory/update";
    }

    @PostMapping("/catecory/update")
    public String update(
            @RequestParam("id") String id,
            @RequestParam("name") String name


    ) throws IllegalStateException, IOException {

        Category category1 = new Category();
        category1.setId(id);
        category1.setName(name);

        Category category = daocategory.findById(id).orElse(null);
        category1.setId(category.getId());
        BeanUtils.copyProperties(category1, category);
        daocategory.save(category1);
        return "redirect:/catecory/index";
    }

}
