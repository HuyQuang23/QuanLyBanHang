package com.poly.lab5.service;


import com.poly.lab5.dao.ProductDAO;
import com.poly.lab5.entity.Item;
import com.poly.lab5.entity.OrderDetail;
import com.poly.lab5.entity.Product;
import com.poly.lab5.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@SessionScope
@Service
public class ShoppingCartService {
    @Autowired
    ProductServiceImpl productService;

    List<OrderDetail> items = new ArrayList<>();

    public List<OrderDetail> getItems() {
        return items;
    }

    public void add(int id) {
        OrderDetail item = items
                .stream()
                .filter(it -> it.getProduct().getId() == id)
                .findFirst()
                .orElse(null);
        if (item != null) {
            item.setQuantity(item.getQuantity() + 1);
            return;
        }

        Product product = productService.findById(id);
        if (product != null) {
            items.add(
                    new OrderDetail(null, product.getPrice(), 1, product, null)
            );
        }
    }

    public void remove(int id) {
        items = items
                .stream()
                .filter(it -> it.getProduct().getId() != id)
                .collect(Collectors.toList());
    }

    public void update(int id, int qty) {
        OrderDetail item = items
                .stream()
                .filter(it -> it.getProduct().getId() == id)
                .findFirst()
                .orElse(null);

        if (item != null) {
            item.setQuantity(qty);
        }
    }

    public int getTotal() {
        int total = 0;
        for (OrderDetail item : items) {
            total += item.getQuantity();
        }
        return total;
    }

    public int getAmount() {
        int amount = 0;
        for (OrderDetail item : items) {
            amount += item.getQuantity() * item.getPrice();
        }
        return amount;
    }

    public void clear() {
        items.clear();
    }

}
