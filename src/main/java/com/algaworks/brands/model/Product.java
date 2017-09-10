package com.algaworks.brands.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Product {
	@Id
	@GeneratedValue
	private Long id_product;
	
	@ManyToOne
	@JoinColumn(name = "id_brand")
	@NotNull(message = "Campo obrigatório!")
	private Brand brand;
	
	@NotEmpty(message = "Campo obrigatório!")
	private String descricao;
	
	@NotEmpty(message = "Campo obrigatório!")
	private Float valor;

	public Long getId_product() {
		return id_product;
	}

	public void setId_product(Long id_product) {
		this.id_product = id_product;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}
}