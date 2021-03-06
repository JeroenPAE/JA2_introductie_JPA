package be.pxl.ja2.jpa;

import be.pxl.ja2.jpa.model.Contact;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Demo1Find {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		try {
			// create entityManagerFactory is much of process power
			entityManagerFactory = Persistence.createEntityManagerFactory("musicdb_pu");
			// create entityManager is not much of process power
			entityManager = entityManagerFactory.createEntityManager();
			Contact contact = entityManager.find(Contact.class, 1);
			System.out.println(contact);
		}
		finally {
			if (entityManager != null) {
				entityManager.close();
			}
			if (entityManagerFactory != null) {
				entityManagerFactory.close();
			}
		}
	}

}
