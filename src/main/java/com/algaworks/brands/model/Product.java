package com.algaworks.brands.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Product {
	@Id
	@GeneratedValue
	private Long idProduct;
	
	@ManyToOne
	@JoinColumn(name = "id_brand")
	@NotNull(message="Marca obrigatória!")
	private Brand brand;
	
	@NotEmpty(message="Descrição obrigatória!")
	private String descricao;

	@NotNull(message = "Valor é obrigatório")
	@DecimalMin(value = "0.01", message = "Valor não pode ser menor que 0,01")
	private float valor;

	public Long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
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
