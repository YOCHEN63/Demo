package com.example.demo.Service.Impl;


import com.example.demo.Redis.RedisService;
import com.example.demo.Service.ProductService;
import com.example.demo.dao.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private RedisService redisService;

    @Autowired
    private ProductDAO productDAO;

    @Override
    public Boolean placeOrder(Long id, Integer quantity) {
        String productId = id.toString();
        Integer stock = redisService.get(productId);

        // 如果库存为空，在一个原子内检查该物品是否被赋值，如果没有则将数据添加到redis中,使用setIfNotExists保证原子性
        if (stock == null) {
            stock = redisService.setIfNotExists(productId, productDAO.findStockById(id));
        }
        // Lua 脚本
        // 检查库存是否大于购买量， 如果大于，则扣减（保证原子性）
        if (redisService.decrIfAvailable(productId, quantity) >= 0) {
            return true;
        } else {
            return false;
        }

    }
}
