package com.thecodereveal.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thecodereveal.core.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
