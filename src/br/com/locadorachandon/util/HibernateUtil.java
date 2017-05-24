package br.com.locadorachandon.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static final SessionFactory fabricaDeSessoes = criarFabricaDeSessoes();

	private static SessionFactory criarFabricaDeSessoes() {
		try {
			Configuration configuracao = new Configuration();
			configuracao.configure();

			ServiceRegistry registro = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties())
					.build();

			SessionFactory fabrica = configuracao.buildSessionFactory(registro);

			return fabrica;
		} catch (Throwable ex) {
			System.err.println("A f�brica de sess�es n�o pode ser criada." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getFabricaDeSessoes() {
		return fabricaDeSessoes;
	}
}
