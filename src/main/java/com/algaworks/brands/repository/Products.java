package com.algaworks.brands.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.algaworks.brands.model.Product;

public interface Products extends JpaRepository<Product, Long> {

}
