package com.devsuperior.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsvendas.entities.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long>{ 
	//tipo da entidade que eh Seller, tipo do ID que eh Long
	//objeto SellerRepository q sera responsavel por acessar os dados do Seller no banco
}
