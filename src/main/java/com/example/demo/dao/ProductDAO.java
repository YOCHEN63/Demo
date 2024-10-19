package com.example.demo.dao;

import com.example.demo.Domain.ProductDO;

import java.util.List;

public interface ProductDAO {

    ProductDO findById(Long id);

    ProductDO findByName(String name);

    List<ProductDO> findAll();

    void save(ProductDO product);

    void update(ProductDO product);

    void delete(Long id);

    Integer findStockById(Long id);
}

