package gm.ciclovida;

import gm.entidad.Contacto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EliminarObjetoPersistente {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();

        // Recuperamos un objeto de la BD y lo eliminamos:
        Contacto contacto = null;
        contacto = em.find(Contacto.class, 3);
        em.getTransaction().begin();
        em.remove(em.merge(contacto));
        em.getTransaction().commit();
        System.out.println("Contacto: " + contacto);
    }
}
