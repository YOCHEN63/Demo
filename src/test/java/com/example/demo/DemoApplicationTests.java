package com.example.demo;

import com.example.demo.Kafka.KafkaService;
import com.example.demo.Service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private KafkaService kafkaService;

    @Autowired
    private ProductService productService;

    @Test
    void contextLoads() {
        productService.placeOrder(1L, 1);
    }

}
