package com.poly.lab5.controller;

import com.poly.lab5.dao.AccountDAO;
import com.poly.lab5.dao.OrderDAO;
import com.poly.lab5.dao.OrderDetailDAO;
import com.poly.lab5.entity.Account;
import com.poly.lab5.entity.Order;
import com.poly.lab5.entity.OrderDetail;
import com.poly.lab5.service.ShoppingCartService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GioHangController {




    @Autowired
    HttpSession session;

    @Autowired
    OrderDAO orderDAO;

    @Autowired
    AccountDAO accountDAO;

    @Autowired
    OrderDetailDAO orderDetail;

    @Autowired
    ShoppingCartService cartService;

    @RequestMapping("/cart/view")
    public String view(Model model) {
        model.addAttribute("cart", cartService);
//        model.addAttribute("count", cartService.getCount());
        return "/cart/index";
    }

    @RequestMapping("/cart/add/{id}")
    public String add(@PathVariable("id") Integer id) {
        cartService.add(id);
        return "redirect:/cart/view";
    }

    @RequestMapping("/cart/remove/{id}")
    public String remove(@PathVariable("id") Integer id) {
        cartService.remove(id);
        return "redirect:/cart/view";
    }

    @RequestMapping("/cart/update/{id}")
    public String update(@PathVariable("id") Integer id,
                         @RequestParam("quantity") Integer qty) {
        cartService.update(id, qty);
        return "redirect:/cart/view";
    }

    @RequestMapping("/cart/clear")
    public String clear() {
        cartService.clear();
        return "redirect:/cart/view";
    }

    //// Thanh Toán ////

@GetMapping("/cart/purchase")
public String Viewpurchase(Model model) {
        model.addAttribute("order", new Order());
        return "cart/ThanhToan";
}
    @PostMapping("/cart/purchase")
    public String purchase(@RequestParam String address,Model model) {
        System.out.println("address=" + address);
        // TODO: Save items to database
        String username = (String) session.getAttribute("username");
        if (username == null){
            String err = "Ban can dang nhap de mua hang";
            model.addAttribute("err", err);
            return "redirect:/account/login";
        }
        Account account = accountDAO.findById(username).orElse(null);
        if (account != null) {
            Order order = new Order();
            order.setAccount(account);
            order.setAddress(address);
            orderDAO.save(order);
            for (OrderDetail item : cartService.getItems()) {
                item.setOrder(order);
                orderDetail.save(item);
            }
            cartService.clear();
        }

        return "redirect:/home/trangchu";
    }
}

