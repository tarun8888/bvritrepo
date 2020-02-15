package com.cg.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.cg.bean.Product;
import com.cg.exception.ProductException;

public class ProductDaoMapImpl implements ProductDao{
	private Map<Integer,Product> map;

	@Override
	public int addProduct(Product product) throws ProductException {
		// TODO Auto-generated method stub
		if(map.containsKey(product.getProductId()))
			throw new ProductException("ID already exsits");
		else
			map.put(product.getProductId(), product);
		return product.getProductId();
	}

	@Override
	public Product findProductById(int productId) throws ProductException {
		// TODO Auto-generated method stub
		Product product = null;
		if(map.containsKey(productId))
			product = map.get(productId);
		else
			throw new ProductException(productId+" Id not found");
		return product;
	}

	@Override
	public Product deleteProductById(int productId) throws ProductException {
		// TODO Auto-generated method stub
		Product product = null;
		if(map.containsKey(productId))
			product = map.remove(productId);
		else
			throw new ProductException(productId+" Id not found");
		return product;
	}

	@Override
	public List<Product> findAllProducts() throws ProductException {
		// TODO Auto-generated method stub
		Collection<Product> collection = map.values();
		List<Product> list = new ArrayList<Product>();
		for(Product p : collection)
			list.add(p);
		return list;
	}

}
