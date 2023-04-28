package com.generation.lojagames.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produto") 
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
	@NotNull(message = "O Atributo nome é obrigatório!") 
	private String nome;

	@NotBlank(message = "O Atributo descricao é obrigatório!") 
    @Size(max = 1000, message = "O atributo descricao deve ter no máximo 1000 de caracteres.")
	private String descricao;

	@NotNull(message = "O Atributo preço é obrigatório!") 
	@Positive
	private BigDecimal preco;

	
	private LocalDate datalancamento;
	
    @Size(max = 1000, message = "O atributo foto deve ter no máximo 1000 de caracteres.")
	private String foto;
    
    @ManyToOne 
    @JsonIgnoreProperties("produto")
	private Categoria categoria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public LocalDate getDatalancamento() {
		return datalancamento;
	}

	public void setDatalancamento(LocalDate datalancamento) {
		this.datalancamento = datalancamento;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
    
    
}


	
