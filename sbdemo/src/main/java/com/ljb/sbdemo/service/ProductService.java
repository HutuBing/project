package com.ljb.sbdemo.service;

import com.ljb.sbdemo.models.model.ProductDTO;

import java.util.List;

public interface ProductService {

    List<ProductDTO> getProductList(Integer type);

}
