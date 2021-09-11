package com.devsuperior.dsvendas.dto;

import java.time.LocalDate;

import com.devsuperior.dsvendas.entities.Sale;

public class SaleDTO {

	private Long id;
	private Integer visited;
	private Integer deals;
	private Double amount;
	private LocalDate date;
	
	//a dependencia do DTO para outro atribuito, nao posso usar a entidade, para nao expor a entidade ao controlador e sim soh DTO (pra nao furar arquitetura)
	private SellerDTO seller;

	public SaleDTO() {
	}

	public SaleDTO(Long id, Integer visited, Integer deals, Double amount, LocalDate date, SellerDTO seller) {
		this.id = id;
		this.visited = visited;
		this.deals = deals;
		this.amount = amount;
		this.date = date;
		this.seller = seller;
	} 
	
	//copiando todos os dados da entidade Sale para entidade SaleDTO
	public SaleDTO(Sale saleEntity) {
		id = saleEntity.getId();
		visited = saleEntity.getVisited();
		deals = saleEntity.getDeals();
		amount = saleEntity.getAmount();
		date = saleEntity.getDate();
		seller = new SellerDTO(saleEntity.getSeller());//preciso converter a entidade seller em sellerDTO
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVisited() {
		return visited;
	}

	public void setVisited(Integer visited) {
		this.visited = visited;
	}

	public Integer getDeals() {
		return deals;
	}

	public void setDeals(Integer deals) {
		this.deals = deals;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public SellerDTO getSeller() {
		return seller;
	}

	public void setSeller(SellerDTO seller) {
		this.seller = seller;
	} 
	

}
