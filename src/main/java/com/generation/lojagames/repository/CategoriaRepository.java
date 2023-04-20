package com.generation.lojagames.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.lojagames.model.Categoria;

public interface CategoriaRepository  extends JpaRepository<Categoria, Long>{
	
		List<Categoria> findAllByGeneroContainingIgnoreCase(@Param("genero")String Genero);
		
		List<Categoria> findByPrecoGreaterThan(@Param("preco")BigDecimal preco);
		
		List<Categoria> findByPrecoLessThanEqual(@Param("preco")BigDecimal preco);
	}


