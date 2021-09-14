package com.thecodereveal.core.services;

import java.util.List;

import com.thecodereveal.core.models.Product;

public interface ProductService {
	
	public Product create(Product product);
	public List<Product> getProducts();
	public void delete(long id);
	public Product update(Product product,Long id);
	public Product getProductById(Long id);

}
