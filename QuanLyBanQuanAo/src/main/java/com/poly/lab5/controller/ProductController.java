package com.poly.lab5.controller;

import com.poly.lab5.dao.CategoryDAO;
import com.poly.lab5.dao.ProductDAO;
import com.poly.lab5.entity.Category;
import com.poly.lab5.entity.Product;
import jakarta.servlet.ServletContext;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")

public class ProductController {

    @Autowired
    ServletContext app;
    @Autowired
    ProductDAO dao;
    @Autowired
    CategoryDAO daocategory;

    @GetMapping("/index")
    public String index(Model model,
                        @RequestParam("p") Optional<Integer> p) {
        Pageable pageable = PageRequest.of(p.orElse(0), 5);

        Product item = new Product();
        model.addAttribute("item", item);
        Page<Product> items = dao.findAll(pageable);
        model.addAttribute("items", items);
        List<Category> list = daocategory.findAll();
        model.addAttribute("categoryeis", list);
        return "product/index";
    }


    @GetMapping("/viewadd")
    public String Viewadd(Model model) {
        List<Category> list = daocategory.findAll();
        model.addAttribute("categoryeis", list);
        return "product/add";
    }

    @PostMapping("/create")
    public String create(
            @RequestParam("name") String name,
            @RequestParam("image") MultipartFile image,
            @RequestParam("price") String price,
            @RequestParam("createDate") String createDate,
            @RequestParam("category") String category
    ) throws IllegalStateException, IOException {
        if (!image.isEmpty()) {
            String fileOrigionalName = image.getOriginalFilename();

            System.out.println(fileOrigionalName);

            //Date
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyymmddhhmmss");
            LocalDateTime now = LocalDateTime.now();
            String datenow = dtf.format(now).toLowerCase();
            File file = new File(app.getRealPath("/files/" + datenow + "_" + fileOrigionalName));

            System.out.println(file.getAbsolutePath());

            image.transferTo(file);

            Category cate = daocategory.findById(category).orElse(null);
            Product product = new Product();
            product.setImage(app.getRealPath("/files/" + datenow + "_" + fileOrigionalName));
            product.setName(name);
            product.setPrice(Double.valueOf(price));
            product.setCategory(cate);
            product.setCreateDate(Date.valueOf(createDate));
            dao.save(product);
        }
        return "redirect:/product/index";
    }

    @GetMapping("/delete/{id}")
    public String create(Model model, @PathVariable("id") String id) {
        dao.deleteById(Integer.valueOf(id));
        List<Category> list = daocategory.findAll();
        model.addAttribute("categoryeis", list);
        return "redirect:/product/index";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable("id") String id, Model model) {
        Product product = dao.findById(Integer.valueOf(id)).orElse(null);
        model.addAttribute("product", product);
        List<Category> list = daocategory.findAll();
        model.addAttribute("categoryeis", list);
        return "product/update";
    }

    @PostMapping("/update")
    public String update(@RequestParam("id") String id,
                         @RequestParam("name") String name,
                         @RequestParam("image") MultipartFile image,
                         @RequestParam("price") String price,
                         @RequestParam("createDate") String createDate,
                         @RequestParam("category") String category
    ) throws IllegalStateException, IOException {
        if (!image.isEmpty()) {
            String fileOrigionalName = image.getOriginalFilename();
            System.out.println(fileOrigionalName);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyymmddhhmmss");
            LocalDateTime now = LocalDateTime.now();
            String datenow = dtf.format(now).toLowerCase();
            File file = new File(app.getRealPath("/files/" + datenow + "_" + fileOrigionalName));
            System.out.println(file.getAbsolutePath());
            image.transferTo(file);


            Category cate = daocategory.findById(category).orElse(null);
            Product product = new Product().builder()
                    .image(app.getRealPath("/files/" + datenow + "_" + fileOrigionalName))
                    .name(name)
                    .price(Double.valueOf(price))
                    .category(cate)
                    .createDate(Date.valueOf(createDate))
                    .build();
            Product product1 = dao.findById(Integer.valueOf(id)).orElse(null);
            product.setId(product1.getId());
            BeanUtils.copyProperties(product, product1);
            dao.save(product);
        }
        return "redirect:/product/index";
    }

    @GetMapping("view-deltail/{id}")
    public String deltail(@PathVariable("id") String id, Model model) {
        Product product = dao.findById(Integer.valueOf(id)).orElse(null);
        model.addAttribute("product", product);
        return "product/deltail";
    }

}


