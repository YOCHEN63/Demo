package com.example.demo.dao.impl;

import com.example.demo.Domain.ProductDO;
import com.example.demo.dao.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    JdbcClient jdbcClient;

    @Override
    public ProductDO findById(Long id) {
        return null;
    }

    @Override
    public ProductDO findByName(String name) {
        return null;
    }

    @Override
    public List<ProductDO> findAll() {
        return List.of();
    }

    @Override
    public void save(ProductDO product) {

    }

    @Override
    public void update(ProductDO product) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Integer findStockById(Long id) {
        return jdbcClient.sql("select stock from product where id = ?")
                .param(id)
                .query(Integer.class)
                .single();
    }
}
