package be.pxl.ja2.jpa.oefening;

import be.pxl.ja2.jpa.model.Contact;
import be.pxl.ja2.jpa.model.Message;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SaveMessage {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;

        try {
            // create entityManagerFactory is much of process power
            entityManagerFactory = Persistence.createEntityManagerFactory("musicdb_pu");
            // create entityManager is not much of process power
            entityManager = entityManagerFactory.createEntityManager();
            Message message = entityManager.find(Message.class, 1);
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
