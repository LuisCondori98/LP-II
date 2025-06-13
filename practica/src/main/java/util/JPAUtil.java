package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static final String PERSISTENCE_UNIT = "practica";

	public static EntityManager getEntityManager() {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		
		return factory.createEntityManager();
	}
	
}
