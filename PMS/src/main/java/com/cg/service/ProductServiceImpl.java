package com.cg.service;

import java.util.List;
import java.util.Random;
import com.cg.bean.Product;
import com.cg.dao.ProductDao;
import com.cg.dao.ProductDaoMapImpl;
import com.cg.exception.ProductException;

public class ProductServiceImpl implements ProductService{
	
	private ProductDao productDao;
	
	public ProductServiceImpl() {
		productDao = new ProductDaoMapImpl();
	}
	
	
	@Override
	public boolean validateName(String productName) {
		// TODO Auto-generated method stub
		return productName.matches("[A-Za-z]+");
	}

	@Override
	public int addProduct(Product product) throws ProductException {
		// TODO Auto-generated method stub
		if(!validateName(product.getProductName()))
			throw new ProductException("name should have aplhabet");
		Random random = new Random();
		int pid = random.nextInt(1000)+10000;
		product.setProductId(pid);
		pid = productDao.addProduct(product);
		return pid;
	}

	@Override
	public Product findProductById(int productId) throws ProductException {
		// TODO Auto-generated method stub
		String pid = String.valueOf(productId);
		if(!pid.matches("[0-9]{5}"))
			throw new ProductException("id should be 5 digits");
		
		return productDao.findProductById(productId);
	}

	@Override
	public Product deleteProductById(int productId) throws ProductException {
		// TODO Auto-generated method stub
		
		String pid = String.valueOf(productId);
		if(!pid.matches("[0-9]{5}"))
			throw new ProductException("id should be 5 digits");
		
		return productDao.deleteProductById(productId);
	}

	@Override
	public List<Product> findAllProducts() throws ProductException {
		// TODO Auto-generated method stub
		return productDao.findAllProducts();
	}

}
