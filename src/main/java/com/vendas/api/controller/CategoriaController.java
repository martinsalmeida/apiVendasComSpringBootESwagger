package com.vendas.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vendas.api.model.Categoria;
import com.vendas.api.repository.CategoriaRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class CategoriaController {
	
	
	@Autowired
	private CategoriaRepository repository;
	
	@GetMapping("/listar")
	@ApiOperation(value = "Listar todas as categorias cadastradas")
	public List<Categoria> listar(){
		return repository.findAll();
	}
	
	@PostMapping("/salvar")
	@ApiOperation(value = "Salva uma categoria")
	public Categoria salvar(@RequestBody Categoria categoria) {
		return repository.save(categoria);
	}
	
	@GetMapping("/listar/{id}")
	@ApiOperation(value = "Retorna uma categoria pelo id")
	public Optional<Categoria> listarCategoria(@PathVariable(value = "id") Long id) {
		return repository.findById(id);
	}
	
	@PutMapping("/categoria")
	@ApiOperation(value = "Atualiza uma categoria")
	public Categoria atualizar (@RequestBody Categoria categoria) {
		return repository.save(categoria);
	}
	
	@DeleteMapping("/categoria")
	@ApiOperation(value = "Exclui uma categoria do sistema")
	public void delete(@RequestBody Categoria categoria) {
		repository.delete(categoria);
	}

}
