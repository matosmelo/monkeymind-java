package br.com.matosmelo.monkeymind.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.matosmelo.monkeymind.infra.CriadorDeSession;
import br.com.matosmelo.monkeymind.model.Usuario;

@Component
public class UsuarioDao {

	private final Session session;

	public UsuarioDao() {
		// Aquisição de sessão
		this.session = CriadorDeSession.getSession();

	}

	// Salva
	public void salva(Usuario usuario) {
		Transaction tx = session.beginTransaction();
		session.save(usuario);
		tx.commit();
	}

	// Altera
	public void alteraUsuario() {
		Usuario usuario = carregaUsuario();
		Transaction tx = session.beginTransaction();
		session.update(usuario);
		tx.commit();
	}

	// Remove usuario
	public void removeUsuario() {
		Usuario usuario = carregaUsuario();
		Transaction tx = session.beginTransaction();
		session.delete(usuario);
		tx.commit();
	}

	// Carrega
	private Usuario carregaUsuario() {
		Usuario usuario = (Usuario) session.load(Usuario.class, 4L);
		return usuario;
	}

	// Lista tudo
	@SuppressWarnings("unchecked")
	public List<Usuario> listaTudo() {
		return this.session.createCriteria(Usuario.class).list();
	}

	// Lê usuario no banco pelo id
	public Usuario carrega(Long id) {
		return (Usuario) this.session.load(Usuario.class, id);
	}

	// Atualiza o usuario no banco
	public void atualiza(Usuario usuario) {
		Transaction tx = session.beginTransaction();
		this.session.update(usuario);
		tx.commit();
	}

	// Remove usuario do banco
	public void remove(Usuario usuario) {
		Transaction tx = session.beginTransaction();
		this.session.delete(usuario);
		tx.commit();

	}

	@SuppressWarnings("unchecked")
	public List<Usuario> busca(String nome) {
		return session
				.createCriteria(Usuario.class)
				.add(Restrictions.or(
						Restrictions.ilike("nome", nome, MatchMode.ANYWHERE),
						Restrictions.ilike("email", nome, MatchMode.ANYWHERE)))
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
