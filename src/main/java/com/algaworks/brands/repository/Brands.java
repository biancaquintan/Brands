package com.algaworks.brands.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.algaworks.brands.model.Brand;


public interface Brands extends JpaRepository<Brand, Long> {

}
