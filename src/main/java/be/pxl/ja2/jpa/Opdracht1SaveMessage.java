package be.pxl.ja2.jpa;

import be.pxl.ja2.jpa.model.Contact;
import be.pxl.ja2.jpa.model.Message;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Scanner;

public class Opdracht1SaveMessage {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("geef een boodschap: ");
		String text = input.nextLine();
		Message message = new Message(text);

		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("musicdb_pu");
			entityManager = entityManagerFactory.createEntityManager();

			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			// bij persist moet je een transaction aanvragen, starten + commiten.
			entityManager.persist(message);
			transaction.commit();
			System.out.println(message);
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
