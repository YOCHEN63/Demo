package com.example.demo.Service.Impl;

import com.example.demo.Domain.ProductDO;
import com.example.demo.Service.ProductService;
import com.example.demo.dao.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private ProductDAO productDAO;

    @Override
    public Boolean placeOrder(Long id, Integer quantity) {
        String productId = id.toString();
        if (Boolean.TRUE.equals(redisTemplate.hasKey(productId))) {
            Integer stock = (Integer) redisTemplate.opsForValue().get(productId);
            if (quantity <= stock) {
                redisTemplate.opsForValue().set(productId, stock - quantity);
                return true;
            } else {
                return false;
            }
        } else {
            Integer stock = productDAO.findStockById(id);
            if (stock >= quantity) {
                redisTemplate.opsForValue().set(productId, stock - quantity);
            }
            return true;
        }
    }
}
