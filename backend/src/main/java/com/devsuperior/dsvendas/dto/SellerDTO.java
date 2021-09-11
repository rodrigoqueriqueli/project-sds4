package com.devsuperior.dsvendas.dto;

import java.io.Serializable;

import com.devsuperior.dsvendas.entities.Seller;

//esse obj nao tem nenhuma relacao com JPA, banco de dados..diferente da entidade Seller, que eh monitorada pelo JPA
public class SellerDTO implements Serializable { //interface pra permitir que o objt seja convertidos p bytes pra ser trafegado na rede 

	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	
	public SellerDTO() {
	}

	public SellerDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public SellerDTO(Seller entity) { //construtor criado pra facilitar pra copiar os dados de uma entidade seller para um obj sellerDTO
		this.id = entity.getId();
		this.name = entity.getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
