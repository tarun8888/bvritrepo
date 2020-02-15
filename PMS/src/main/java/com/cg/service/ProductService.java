package com.cg.service;

import java.util.List;

import com.cg.bean.Product;
import com.cg.exception.ProductException;

public interface ProductService {
	public int addProduct(Product product) throws ProductException;
	public Product findProductById(int productId) throws ProductException;
	public Product deleteProductById(int productId) throws ProductException;
	public List<Product> findAllProducts() throws ProductException;
	public boolean validateName(String productName);


}
