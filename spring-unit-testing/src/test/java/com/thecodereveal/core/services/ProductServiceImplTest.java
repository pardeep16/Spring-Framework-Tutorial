package com.thecodereveal.core.services;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.thecodereveal.core.models.Product;
import com.thecodereveal.core.repository.ProductRepository;
import com.thecodereveal.core.test.SpringUnitTest;

import javassist.NotFoundException;

public class ProductServiceImplTest extends SpringUnitTest {

	@InjectMocks
	ProductServiceImpl productService;
	
	@Mock
	Product product;
	
	@Mock
	ProductRepository productRepository;
	
	@BeforeEach
	public void init() {
		
		Mockito.when(product.getId()).thenReturn(1L);
		Mockito.when(product.getProductName()).thenReturn("T-Shirt");
		Mockito.when(product.getProductPrice()).thenReturn(500.00);
		Mockito.when(product.getProductCategory()).thenReturn("Clothing");
	}
	

	@Test
	public void testCreateProduct() {
		
		
		Mockito.when(productRepository.save(Mockito.any())).thenReturn(product);
		
		Product createdItem=productService.create(product);
		assertEquals("T-Shirt", createdItem.getProductName());
		
	}
	
	@Test
	public void testgetProducts() {
		Mockito.when(productRepository.findAll()).thenReturn(Arrays.asList(product));
		
		List<Product> productItems=productService.getProducts();
		assertEquals(1, productItems.size());
		
	}
	
	@Test
	public void testUpdateProduct() {
		Mockito.when(product.getProductName()).thenReturn("Shirt");
		Mockito.when(productRepository.save(Mockito.any())).thenReturn(product);
		
		Product updatedItem=productService.update(product, product.getId());
		assertEquals("Shirt", updatedItem.getProductName());
		
	}
	
	@Test
	@Timeout(value = 1000)
	public void testdeleteProduct() {
		Mockito.doNothing().when(productRepository).delete(Mockito.any());
		Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(product));
		ProductServiceImpl service=mock(ProductServiceImpl.class);
		
		service.delete(1L);
		verify(service).delete(Mockito.anyLong());
		
	}
	
}
