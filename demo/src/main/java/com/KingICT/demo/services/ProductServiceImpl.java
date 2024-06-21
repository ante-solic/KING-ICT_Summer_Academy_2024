package com.KingICT.demo.services;

import com.KingICT.demo.models.Product;
import com.KingICT.demo.repositories.ProductRepository;
import com.KingICT.demo.wrappers.ProductList;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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

    public List<Product> getAllProducts(){
        String url =  "https://dummyjson.com/products";
        ProductList response = restTemplate.getForObject(url, ProductList.class);

        List<Product> products = response.getProducts();

        return products;
    }

    public List<Product> filterByCategoryAndPrice(String category, double priceMax, double priceMin){
        String url =  "https://dummyjson.com/products";
        ProductList response = restTemplate.getForObject(url, ProductList.class);

        List<Product> products = response.getProducts();

        List<Product> filteredProducts = products.stream().filter(
                Product -> Product.getCategory().equals(category)
                        && Product.getPrice() > priceMin && Product.getPrice() < priceMax).toList();

        return filteredProducts;
    }
}
