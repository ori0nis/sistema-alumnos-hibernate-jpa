package gm.ciclovida;

import gm.entidad.Contacto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EstadoPersistido {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();

        // Pasamos el objeto de transitivo a persistente:
        Contacto contacto = new Contacto();
        contacto.setEmail("cgomez@email.com");
        contacto.setTelefono("111222333");

        em.getTransaction().begin();
        em.persist(contacto);
        em.getTransaction().commit(); // Hasta que no se hace commit, el contacto no está en la BD

        System.out.println("Contacto: " + contacto);
    }
}
