package com.vendas.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vendas.api.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
