package com.myron.ProductCatalog.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myron.ProductCatalog.models.Product;
import com.myron.ProductCatalog.repositories.ProductRepository;

@Service
public class ProductService {
	private ProductRepository productRepository;
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public List<Product> allProducts(){
		return (List<Product>) productRepository.findAll();
	}
	
	public Product findOne(Long id) {
		return productRepository.findOne(id);
	}
	
	public void deleteProduct(Long id) {
		productRepository.delete(id);
	}
	
	public void addProduct(Product product) {
		productRepository.save(product);
	}
	
	public void updateProduct(Product product) {
		productRepository.save(product);
	}
	
}
