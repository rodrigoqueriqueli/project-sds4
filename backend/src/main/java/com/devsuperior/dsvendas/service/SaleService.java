package com.devsuperior.dsvendas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.entities.Sale;
import com.devsuperior.dsvendas.repositories.SaleRepository;
import com.devsuperior.dsvendas.repositories.SellerRepository;

//Registar a classe SaleService como um componente so sistema, e assim pode ser injetada em outroso componentes
//Impementacao de um obj de serviço que por sua vez chama um  obj repository

@Service 
public class SaleService {

	//declarando dependencia com o sellerRepository
	@Autowired	//@Autowired injeta(instancia o obj) de forma transparente, o fmwk faz isso automaticamente
	private SaleRepository repository;
	
	//injecao desse objeto para deixar salvo em memoria, e nao precisar mais buscar no BD (poucos vendedores, entao da pra fazer isso)
	@Autowired
	private SellerRepository sellerrepository; 
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable){ //pageable pra nao pegar tudo e sim por pagina..busca paginada
		sellerrepository.findAll(); //nao preciso atribuir a nenhuma var(soh quero trazer pra memoria), a JPA vai armazenar esses vended em cash
		Page<Sale> result = repository.findAll(pageable); //o repository retorna entidade, na sequencia preciso converter pra DTO
		return result.map(x -> new SaleDTO(x)); //funcao map converte a colecao original pra outro tipo de colecao
	}
}
