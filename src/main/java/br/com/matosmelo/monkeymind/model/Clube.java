package br.com.matosmelo.monkeymind.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Clube {
	@Id
	@GeneratedValue
	private Long id;
	@NotNull(message="Nome precisa ser preenchido")
	private String nome;
	@NotNull(message="Cidade precisa ser preenchido")	
	private String cidade;

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

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

}
