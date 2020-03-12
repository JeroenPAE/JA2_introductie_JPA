package be.pxl.ja2.jpa;

import be.pxl.ja2.jpa.model.Contact;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Demo2Persist {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("musicdb_pu");
			entityManager = entityManagerFactory.createEntityManager();
			Contact sophie = new Contact("Sophie", 555666, "sophie@pxl.be");
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			// bij persist moet je een transaction aanvragen, starten + commiten.
			entityManager.persist(sophie);
			transaction.commit();
			System.out.println(sophie);
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
