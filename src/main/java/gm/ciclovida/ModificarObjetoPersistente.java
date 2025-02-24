package gm.ciclovida;

import gm.entidad.Contacto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ModificarObjetoPersistente {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();

        // Recuperamos un objeto de la BD y lo modificamos:
        Contacto contacto = null;
        contacto = em.find(Contacto.class, 3);
        contacto.setEmail("cgomez2@email.com");
        em.getTransaction().begin();
        em.persist(contacto);
        em.getTransaction().commit();
        System.out.println("Contacto: " + contacto);
    }
}
