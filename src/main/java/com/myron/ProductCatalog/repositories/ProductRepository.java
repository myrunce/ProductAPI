package com.myron.ProductCatalog.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myron.ProductCatalog.models.Product;


@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
	
}
