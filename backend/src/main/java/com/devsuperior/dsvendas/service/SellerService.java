package com.devsuperior.dsvendas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsvendas.dto.SellerDTO;
import com.devsuperior.dsvendas.entities.Seller;
import com.devsuperior.dsvendas.repositories.SellerRepository;

//Registar a classe SellerService como um componente so sistema, e assim pode ser injetada em outroso componentes
//Impementacao de um obj de serviço que por sua vez chama um  obj repository

@Service 
public class SellerService {

	//declarando dependencia com o sellerRepository
	@Autowired	//@Autowired injeta(instancia o obj) de forma transparente, o fmwk faz isso automaticamente
	private SellerRepository repository;
	
	public List<SellerDTO> findAll(){
		List<Seller> result = repository.findAll(); //o repository retorna entidade, na sequencia preciso converter pra DTO
		return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList()); //funcao map converte a colecao original pra outro tipo de colecao
	}
}
