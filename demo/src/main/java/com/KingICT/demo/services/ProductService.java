package com.KingICT.demo.services;

import com.KingICT.demo.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    Product getProduct(Long id);

    List<Product> getAllProducts();

    List<Product> filterByCategoryAndPrice(String category, double priceMax, double priceMin);
}
