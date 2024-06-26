package com.KingICT.demo.controllers;

import com.KingICT.demo.models.Product;
import com.KingICT.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id){
        return productService.getProduct(id);
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{category}/{priceMax}/{priceMin}")
    public List<Product> filterByCategoryAndPrice(@PathVariable String category, @PathVariable double priceMax, @PathVariable double priceMin){
        return productService.filterByCategoryAndPrice(category, priceMax, priceMin);
    }

    @GetMapping("/search/{parameter}")
    public List<Product> searchByName(@PathVariable String parameter){
        return productService.searchByParameter(parameter);
    }
}
