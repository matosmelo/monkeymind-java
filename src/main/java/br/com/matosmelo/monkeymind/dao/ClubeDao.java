package br.com.matosmelo.monkeymind.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.matosmelo.monkeymind.infra.CriadorDeSession;
import br.com.matosmelo.monkeymind.model.Clube;

@Component
public class ClubeDao {

	private final Session session;

	public ClubeDao() {
		// Aquisição de sessão
		this.session = CriadorDeSession.getSession();

	}

	// Salva
	public void salva(Clube clube) {
		Transaction tx = session.beginTransaction();
		session.save(clube);
		tx.commit();
	}

	// Altera
	public void alteraClube() {
		Clube clube = carregaClube();
		Transaction tx = session.beginTransaction();
		clube.setNome("Sao Paulo");
		clube.setCidade("Sao Paulo");
		session.update(clube);
		tx.commit();
	}

	// Remove litico
	public void removeClube() {
		Clube clube = carregaClube();
		Transaction tx = session.beginTransaction();
		session.delete(clube);
		tx.commit();
	}

	// Carrega
	private Clube carregaClube() {
		Clube clube = (Clube) session.load(Clube.class, 4L);
		return clube;
	}

	// Lista tudo
	public List<Clube> listaTudo() {
		return this.session.createCriteria(Clube.class).list();
	}

	// Lê Clube no banco pelo id
	public Clube carrega(Long id) {
		return (Clube) this.session.load(Clube.class, id);
	}

	// Atualiza o Clube no banco
	public void atualiza(Clube clube) {
		Transaction tx = session.beginTransaction();
		this.session.update(clube);
		tx.commit();
	}

	// Remove Clube do banco
	public void remove(Clube clube) {
		Transaction tx = session.beginTransaction();
		this.session.delete(clube);
		tx.commit();

	}

	@SuppressWarnings("unchecked")
	public List<Clube> busca(String nome) {
		return session
				.createCriteria(Clube.class)
				.add(Restrictions.or(
						Restrictions.ilike("nome", nome, MatchMode.ANYWHERE),
						Restrictions.ilike("cidade", nome, MatchMode.ANYWHERE)))
				.list();
		// return session.createCriteria(Litico.class)
		// .add(Restrictions.ilike("nome", nome, MatchMode.ANYWHERE))
		// .add(Restrictions.ilike("partido", nome, MatchMode.ANYWHERE))
		// .list();
	}
	// @SuppressWarnings("unchecked")
	// public List<Litico> busca(String nome) {
	// return this.session.createQuery(
	// "select nome from Litico as nome where nome=" + nome).list();
	// }

	// public List<Litico> busca(String nome) {
	// return session.createCriteria(Litico.class)
	// .add(Restrictions.ilike("nome", nome, MatchMode.ANYWHERE))
	// .list();
	// }

}
