package com.poly.lab5.controller;

import com.poly.lab5.dao.AccountDAO;
import com.poly.lab5.dao.OrderDAO;
import com.poly.lab5.dao.OrderDetailDAO;
import com.poly.lab5.entity.Account;
import com.poly.lab5.entity.Order;
import com.poly.lab5.entity.OrderDetail;
import com.poly.lab5.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class LichSuConTroller {
    @Autowired
    OrderDAO dao;

    @Autowired
    OrderDetailDAO orderDetailDAO;

    @GetMapping("/admin")
    public String login2(Model model, @RequestParam("p") Optional<Integer> p) {
        Pageable pageable = PageRequest.of(p.orElse(0), 5);
        Page<Order> items = dao.findAll(pageable);
        model.addAttribute("LS", items);
        List<OrderDetail> ff = orderDetailDAO.findAll();
        model.addAttribute("LSii", ff);
        return "/Admin/TTmuaHang";
    }

    @GetMapping("view-chitiet/{id}")
    public String deltail(@PathVariable("id") String id, Model model) {
        OrderDetail product = orderDetailDAO.findById(Long.valueOf(id)).orElse(null);
        model.addAttribute("product", product);
        return "/Admin/chiTiet";
    }
}
