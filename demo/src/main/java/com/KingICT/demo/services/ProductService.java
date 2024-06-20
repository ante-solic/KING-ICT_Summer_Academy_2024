package com.KingICT.demo.services;

import com.KingICT.demo.models.Product;
import org.springframework.stereotype.Service;

public interface ProductService {
    Product getProduct(Long id);
}
