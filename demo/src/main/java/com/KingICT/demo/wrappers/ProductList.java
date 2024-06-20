package com.KingICT.demo.wrappers;

import com.KingICT.demo.models.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ProductList {
    private List<Product> products;

    public ProductList(){
        products = new ArrayList<>();
    }
}
