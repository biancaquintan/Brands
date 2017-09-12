package com.algaworks.brands.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;

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
	
	@NotNull(message = "Valor obrigatório!")
	@DecimalMin(value = "0.01", message = "O valor não pode ser menor que 0,01!")
	@DecimalMax(value = "9999999.99", message = "O valor não pode ser maior que 9999999,99!")
	@NumberFormat(pattern = "#,##0.00")	
	private float valor;

	public Long getIdProduct() {
		return id_product;
	}

	public void setIdProduct(Long idProduct) {
		this.id_product = idProduct;
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

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
}