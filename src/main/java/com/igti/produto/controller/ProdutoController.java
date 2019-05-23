package com.igti.produto.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.igti.produto.entity.Produto;
import com.igti.produto.repository.ProdutoRepository;
import com.igti.produto.vo.ProdutoRequest;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	//atividade 01 - salvar
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> criar(@RequestBody @Valid ProdutoRequest request) {
		Produto produto = new Produto();
		produto.setNome(request.getNome());
		produto.setDescricao(request.getDescricao());
		produto.setQuantidade(request.getQuantidade());
		produto.setValor(request.getValor());
		
		produtoRepository.save(produto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	//atividade 02 - consulta todos os produtos
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Produto>> listar() {

		List<Produto> produtos = produtoRepository.findAll();
		return new ResponseEntity<>(produtos, HttpStatus.OK);
	}
	
	
	//atividade 03 - consulta por nome
	@RequestMapping(path = "/nome/{nome}", method = RequestMethod.GET )
	public ResponseEntity<List<Produto>> obterByNome(@PathVariable String nome) {

		List<Produto> produtos = produtoRepository.findByNome(nome);

		if (produtos != null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(produtos, HttpStatus.OK);
	}
	
	
	//atividade 04 -- consulta por id
	@RequestMapping(path = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Produto> obterById(@PathVariable String id) {

		Optional<Produto> produtoOptional = produtoRepository.findById(id);

		if (!produtoOptional.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(produtoOptional.get(), HttpStatus.OK);
	}
	
	
	//atividade 05 - remover produto
	@RequestMapping(path = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable String id) {
		
		Optional<Produto> produtoOptional = produtoRepository.findById(id);
		
		if (!produtoOptional.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		produtoRepository.delete((produtoOptional.get()));
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
