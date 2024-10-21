package com.example.demo.Controller;

import com.example.demo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/products")
public class OrderController {


    @Autowired
    ProductService productService;

}
