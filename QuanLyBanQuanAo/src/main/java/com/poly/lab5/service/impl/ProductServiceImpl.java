package com.poly.lab5.service.impl;

import com.poly.lab5.dao.ProductDAO;
import com.poly.lab5.entity.Product;
import com.poly.lab5.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;
@SessionScope
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDAO proDuctDao;

    @Override
    public List<Product> getAllSort(Sort sort) {
        return proDuctDao.findAll(sort);
    }

    @Override
    public Page<Product> getAllPage(Pageable pageable) {
        return proDuctDao.findAll(pageable);
    }

    @Override
    public List<Product> getAll() {
        return proDuctDao.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return proDuctDao.findById(id).orElse(null);
    }


    @Override
    public void updateProduct(Product product) {
        proDuctDao.save(product);
    }

    @Override
    public void removeProduct(Integer id) {
        proDuctDao.deleteById(id);
    }

    @Override
    public void addProduct(Product product) {
        proDuctDao.save(product);
    }
}
