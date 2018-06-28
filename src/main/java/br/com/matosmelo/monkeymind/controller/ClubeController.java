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
import br.com.matosmelo.monkeymind.dao.ClubeDao;
import br.com.matosmelo.monkeymind.model.Clube;

@Resource
public class ClubeController {
	private final ClubeDao dao;
	private final Result result;
	private final Validator validator;

	// Construtor
	public ClubeController(ClubeDao dao, Result result, Validator validator) {
		this.dao = dao;
		this.result = result;
		this.validator = validator;
	}

	// Index
	@Get("/")
	public void index() {
	}

	// Lista os clubes
	@Get("/clube/lista")
	public List<Clube> lista() {
		return dao.listaTudo();
	}

	// Mostra o formulario
	@Get("/clube/novo")
	public void formulario() {
	}

	// Adiciona clube
	@Post("/clube/novo")
	public void adiciona(final Clube clube) {
		validator.validate(clube);
		validator.onErrorUsePageOf(ClubeController.class).formulario();
		dao.salva(clube);
		// Retorna para lista apos adicao
		result.redirectTo(this).lista();
	}

	// Edita clube
	@Get("/clube/{id}")
	public Clube edita(Long id) {
		return dao.carrega(id);

	}

	// Altera clube
	@Put("/clube/{clube.id}")
	public void altera(Clube clube) {
		validator.validate(clube);
		validator.onErrorUsePageOf(ClubeController.class)
				.edita(clube.getId());

		dao.atualiza(clube);
		result.redirectTo(this).lista();
	}

	// Remove clube
	@Delete("/clube/{id}")
	public void remove(Long id) {
		Clube clube = dao.carrega(id);
		dao.remove(clube);
		result.redirectTo(this).lista();
	}

	@Get("/clube/pesquisa")
	public void pesquisa() {
	}

	@Get
	@Path("/clube/busca")
	public List<Clube> busca(String nome) {
		return dao.busca(nome);

	}
}
