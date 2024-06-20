package com.KingICT.demo.services;

import com.KingICT.demo.models.Product;
import com.KingICT.demo.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    @Autowired
    private RestTemplate restTemplate;

    private final ProductRepository productRepository;

    public Product getProduct(Long id){
        String url =  String.format("https://dummyjson.com/products/%d", id);
        ResponseEntity<Product> response = restTemplate.getForEntity(url, Product.class);

        return response.getBody();
    }
}
