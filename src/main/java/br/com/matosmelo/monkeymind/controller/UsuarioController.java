package br.com.matosmelo.monkeymind.controller;

import java.util.List;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.matosmelo.monkeymind.dao.UsuarioDao;
import br.com.matosmelo.monkeymind.model.Usuario;

@Resource
public class UsuarioController {
	private final UsuarioDao dao;
	private final Result result;
	private final Validator validator;

	// Construtor
	public UsuarioController(UsuarioDao dao, Result result, Validator validator) {
		this.dao = dao;
		this.result = result;
		this.validator = validator;
	}

	// Usuarios
	@Get("usuarios")
	public List<Usuario> usuarios() {
		return dao.listaTudo();
	}

	// Mostra o formulario usuario
	@Get("/usuario/novo")
	public void formulario() {
	}

	// Adiciona usuario
	@Post("/usuario/novo")
	public void adiciona(final Usuario usuario) {
		validator.validate(usuario);
		validator.onErrorUsePageOf(UsuarioController.class).formulario();
		dao.salva(usuario);
		// Retorna para lista apos adicao
		result.redirectTo(this).usuarios();
	}

	// Edita usuario
	@Get("/usuario/{id}")
	public Usuario edita(Long id) {
		return dao.carrega(id);
	}

	// Altera usuario
	@Put("/usuario/{usuario.id}")
	public void altera(Usuario usuario) {
		validator.validate(usuario);
		validator.onErrorUsePageOf(UsuarioController.class).edita(
				usuario.getId());

		dao.atualiza(usuario);
		result.redirectTo(this).usuarios();
	}

	// Remove usuario
	@Delete("/usuario/{id}")
	public void remove(Long id) {
		Usuario usuario = dao.carrega(id);
		dao.remove(usuario);
		result.redirectTo(this).usuarios();
	}

	@Get("/usuario/pesquisa")
	public void pesquisa() {
	}

	@Get
	@Path("/usuario/busca")
	public List<Usuario> busca(String nome) {
		return dao.busca(nome);

	}
}
