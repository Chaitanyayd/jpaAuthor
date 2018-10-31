package com.cg.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	static EntityManagerFactory emFact = null;
	static EntityManager entityManager = null;
	public static EntityManager getEntityManager(){
		emFact = Persistence.createEntityManagerFactory("JPA-PU");
		entityManager = emFact.createEntityManager();
		return entityManager;
		
	}

}
