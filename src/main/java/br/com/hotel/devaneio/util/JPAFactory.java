package br.com.hotel.devaneio.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAFactory {

	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("hotel1800");

	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}

}