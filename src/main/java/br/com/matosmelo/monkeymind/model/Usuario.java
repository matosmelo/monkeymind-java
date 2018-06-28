package br.com.matosmelo.monkeymind.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Usuario {
	@Id
	@GeneratedValue
	private Long id;
	@NotNull(message="Nome precisa ser preenchido")
	private String nome;
	@NotNull(message="Email precisa ser preenchido")	
	private String email;
	@NotNull(message="Senha precisa ser preenchido")	
	private String senha;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

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


}
