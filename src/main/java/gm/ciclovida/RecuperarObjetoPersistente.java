package gm.ciclovida;

import gm.entidad.Contacto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class RecuperarObjetoPersistente {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();

        // Recuperamos un objeto de la BD:
        Contacto contacto = null;
        contacto = em.find(Contacto.class, 3);
        System.out.println("Contacto: " + contacto);
    }
}
