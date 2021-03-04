package com.vendas.api.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vendas.api.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	public List<Produto> nome(String nome);
	
	public List<Produto> findByNome(String nome);
	
	public List<Produto> findByNomeContaining(String nome);

	public List<Produto> findByPrecoBetween(BigDecimal precoInicial, BigDecimal precoFinal);
	
	public List<Produto> findByNomeContainingAndCategoriaId(String nome, Long categoriaId);
	
}
