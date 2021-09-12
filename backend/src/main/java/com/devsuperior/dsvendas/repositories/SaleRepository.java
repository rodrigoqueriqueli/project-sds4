package com.devsuperior.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsvendas.dto.SalesSuccessDTO;
import com.devsuperior.dsvendas.dto.SalesSumDTO;
import com.devsuperior.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{ 
	//tipo da entidade que eh Sale, tipo do ID que eh Long
	//objeto SaleRepository q sera responsavel por acessar os dados do Sale no banco
	
	@Query("SELECT new com.devsuperior.dsvendas.dto.SalesSumDTO(obj.seller, SUM (obj.amount)) "
			+ "FROM Sale AS obj GROUP BY obj.seller") //obj(apelido) nessa linha representa cada objeto sale buscado no banco
	List<SalesSumDTO> amountGroupedBySeller();
	
	@Query("SELECT new com.devsuperior.dsvendas.dto.SalesSuccessDTO(obj.seller, SUM (obj.visited), SUM (obj.deals)) "
			+ "FROM Sale AS obj GROUP BY obj.seller") 
	List<SalesSuccessDTO> successGroupedBySeller();
}
