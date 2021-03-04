package com.vendas.api.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vendas.api.model.Produto;
import com.vendas.api.repository.ProdutoRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class ProdutoController {

	@Autowired
	private ProdutoRepository repository;
	
	@GetMapping("/produtos")
	@ApiOperation(value = "Listar todos os produtos cadastrados")
	public List<Produto> listar(){
		return repository.findAll();
	}
	
	@PostMapping("/produto")
	@ApiOperation(value = "Salva um produto")
	public Produto salvar(@RequestBody Produto produto) {
		return repository.save(produto);
	}
	
	@GetMapping("/produto/nome")
	@ApiOperation(value = "Retorna um produto pelo nome")
	public List<Produto> listarProdutoNome(String nome){
		//return repository.nome(nome);
		//return repository.findByNome(nome);
		return repository.findByNomeContaining(nome);
	}
	
	@GetMapping("/produto/preco")
	@ApiOperation(value = "Retorna um produto pelo preço")
	public List<Produto> listarPorPreco(BigDecimal precoInicial, BigDecimal precoFinal){
		return repository.findByPrecoBetween(precoInicial, precoFinal);
	}
	
	@GetMapping("/produto/nome-categoria")
	@ApiOperation(value = "Retorna um produto pelo nome e ID")
	public List<Produto> listarPorNomeCategoria(String nome, long categoriaId){
		return repository.findByNomeContainingAndCategoriaId(nome, categoriaId);
	}
	
	

	@PutMapping("/produto")
	@ApiOperation(value = "Atualiza um produto")
	public Produto alterar(@RequestBody Produto produto) {
		return repository.save(produto);
	}
	
	@ApiOperation(value = "Exclui um produto cadastrado")
	@DeleteMapping("/produto")
	public void excluir(@RequestBody Produto produto){
		repository.delete(produto);
	}
	
}
