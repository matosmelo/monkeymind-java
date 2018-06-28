package br.com.matosmelo.monkeymind.infra;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import br.com.caelum.vraptor.ioc.ComponentFactory;

public class CriadorDeSession implements ComponentFactory<Session> {

	public static Session getSession() {
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		configuration.configure();
	
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		return session;
	}

	public Session getInstance() {
		// TODO Auto-generated method stub
		return null;
	}

}
