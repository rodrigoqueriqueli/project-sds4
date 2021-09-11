package com.devsuperior.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsvendas.dto.SellerDTO;
import com.devsuperior.dsvendas.service.SellerService;

@RestController	//annotation para indicar que essa classe eh um controlador REST
@RequestMapping(value = "/sellers") //para indicar qual eh o path desse recurso web
public class SellerController {

	@Autowired //pra injetar o service
	private SellerService service;
	
	//metodo pra representar um endpoint
	@GetMapping
	public ResponseEntity<List<SellerDTO>> findAll(){
		List<SellerDTO> list = service.findAll();
		return ResponseEntity.ok(list); //no corpo da resposta 200 vira essa lista
	}
}
