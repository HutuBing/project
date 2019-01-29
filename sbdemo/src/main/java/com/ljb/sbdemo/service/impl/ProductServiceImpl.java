package com.ljb.sbdemo.service.impl;

import com.ljb.sbdemo.models.model.ProductDTO;
import com.ljb.sbdemo.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public List<ProductDTO> getProductList(Integer type) {
        return null;
    }
}
