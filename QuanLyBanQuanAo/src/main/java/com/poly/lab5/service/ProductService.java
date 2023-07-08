package com.poly.lab5.service;

import com.poly.lab5.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ProductService {
    public List<Product> getAllSort(Sort sort);

    Page<Product> getAllPage(Pageable pageable);

    public List<Product> getAll();

    Product findById(Integer id);

    public void updateProduct(Product product);

    public void removeProduct(Integer id);

    public void addProduct(Product product);

}
