package com.thecodereveal.core.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thecodereveal.core.models.Product;
import com.thecodereveal.core.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public Product create(Product product) {
		
		Product createdItem=productRepository.save(product);
		
		return createdItem;
	}

	@Override
	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	@Override
	public void delete(long id) {
		Optional<Product> product=productRepository.findById(id);
		productRepository.delete(product.get());
	}

	@Override
	public Product update(Product product, Long id) {
		Product updateItem=productRepository.save(product);
		return updateItem;
	}

	@Override
	public Product getProductById(Long id) {
		
		return null;
	}

}
