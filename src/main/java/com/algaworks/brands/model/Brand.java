package com.algaworks.brands.model;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Brand {
	@Id
	@GeneratedValue
	@Column(name="id_brand")
	private Long idBrand;
	@NotEmpty(message="Marca obrigatória!")
	private String brand;
	
	@NotEmpty(message="Ramo de atividade obrigatório!")
	private String ramo_atividade;
	
	@OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
	private Set<Product> products;

	public Long getIdBrand() {
		return idBrand;
	}

	public void setIdBrand(Long idBrand) {
		this.idBrand = idBrand;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	
}
