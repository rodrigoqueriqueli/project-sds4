package com.devsuperior.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.dto.SalesSuccessDTO;
import com.devsuperior.dsvendas.dto.SalesSumDTO;
import com.devsuperior.dsvendas.service.SaleService;

@RestController	//annotation para indicar que essa classe eh um controlador REST
@RequestMapping(value = "/sales") //para indicar qual eh o path desse recurso web
public class SaleController {

	@Autowired //pra injetar o service
	private SaleService service;
	
	//metodo pra representar um endpoint
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable){
		Page<SaleDTO> list = service.findAll(pageable);
		return ResponseEntity.ok(list); //no corpo da resposta 200 vira essa lista
	}
	
	//metodo pra representar um endpoint
	@GetMapping(value= "/amount-by-seller")
	public ResponseEntity<List<SalesSumDTO>> amountGroupedBySeller(){
		List<SalesSumDTO> list = service.amountGroupedBySeller();
		return ResponseEntity.ok(list); //no corpo da resposta 200 vira essa lista
	}
		
	//metodo pra representar um endpoint
	@GetMapping(value= "/success-by-seller")
	public ResponseEntity<List<SalesSuccessDTO>> successGroupedBySeller(){
		List<SalesSuccessDTO> list = service.successGroupedBySeller();
		return ResponseEntity.ok(list); //no corpo da resposta 200 vira essa lista
	}
		
		
		
}
