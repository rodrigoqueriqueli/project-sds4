package com.devsuperior.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{ 
	//tipo da entidade que eh Sale, tipo do ID que eh Long
	//objeto SaleRepository q sera responsavel por acessar os dados do Sale no banco
}
