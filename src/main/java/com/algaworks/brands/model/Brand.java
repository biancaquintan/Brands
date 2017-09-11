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
	
	@NotEmpty(message="Campo obrigatório!")
	private String nome_marca;
	
	@NotEmpty(message="Campo obrigatório!")
	private String ramo_atividade;
	
	@OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
	private Set<Product> products;

	public Long getIdBrand() {
		return idBrand;
	}

	public void setIdBrand(Long idBrand) {
		this.idBrand = idBrand;
	}

	public String getNome_marca() {
		return nome_marca;
	}

	public void setNome_marca(String nome_marca) {
		this.nome_marca = nome_marca;
	}

	public String getRamo_atividade() {
		return ramo_atividade;
	}

	public void setRamo_atividade(String ramo_atividade) {
		this.ramo_atividade = ramo_atividade;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
}