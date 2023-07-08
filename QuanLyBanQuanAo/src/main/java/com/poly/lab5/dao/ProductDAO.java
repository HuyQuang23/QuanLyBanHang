package com.poly.lab5.dao;

import com.poly.lab5.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDAO extends JpaRepository<Product, Integer>
{
}
