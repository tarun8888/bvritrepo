package com.cg.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import com.cg.service.ProductService;
import com.cg.service.ProductServiceImpl;
import com.cg.bean.Product;
import com.cg.exception.ProductException;


public class Client {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		Product product = null;
		ProductService productService = new ProductServiceImpl();
		List<Product> list = null;
		
		while(true) {
		System.out.println("1. add product");
		System.out.println("2. find product");
		System.out.println("3. delete product");
		System.out.println("4. list products");
		System.out.println("5. exit");
		System.out.println("\nenter your choice");
		int choice = Integer.parseInt(br.readLine());
		
		switch(choice) {
		case 1: 
			try {
				System.out.println("enter product name");
				String name = br.readLine();
				System.out.println("enter product price");
				double price = Double.parseDouble(br.readLine());
				product= new Product();
				product.setProductName(name);
				product.setPrice(price);
				int pid = productService.addProduct(product); 
				System.out.println("product ID = "+pid);
			}
			catch(ProductException pe) {
				pe.printStackTrace();
			}break;
		
		case 2:
			try {
				System.out.println("enter product ID");
				int pid = Integer.parseInt(br.readLine());
				product = productService.findProductById(pid);
				System.out.println("product name = "+product.getProductName());
				System.out.println("product price = "+product.getPrice());
			}
			catch(ProductException pe) {
				pe.printStackTrace();
			}break;
		
		case 3:
			try {
				System.out.println("enter product ID");
				int pid = Integer.parseInt(br.readLine());
				product = productService.deleteProductById(pid);
				System.out.println("deleted product name = "+product.getProductName());
				System.out.println("deleted product price = "+product.getPrice());
				
			}
			catch(ProductException pe) {
				pe.printStackTrace();
			}break;
		
		case 4:
			try {
				list = productService.findAllProducts();
				list.stream().forEach(p->System.out.println(p.getProductId()+" "+p.getProductName()+" "+p.getPrice()));
			}
			catch(ProductException pe) {
				pe.printStackTrace();
			}break;
		case 5:
			System.out.println("THANK you! :)");
			return;
		
		default: 
			System.out.println("enter valid choice! ");
			break;
		
		}
		
		}

	}

}
