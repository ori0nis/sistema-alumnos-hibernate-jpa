package gm.test;

import gm.entidad.Alumno;
import gm.entidad.Contacto;
import gm.entidad.Domicilio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PersistenciaCascadaTest {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();

        // Creamos objetos para unirlos y modificarlos en cascada:
        Domicilio domicilio = new Domicilio();
        domicilio.setCalle("Plutón");
        domicilio.setNumCalle("10");
        domicilio.setPais("México");

        Contacto contacto = new Contacto();
        contacto.setEmail("hernandez@email.com");
        contacto.setTelefono("777888999");

        Alumno alumno = new Alumno();
        alumno.setNombre("Julia");
        alumno.setApellido("López");
        alumno.setDomicilio(domicilio);
        alumno.setContacto(contacto);

        // Gracias a la persistencia en cascada, ni siquiera necesitamos hacer commit primero de las entidades de
        // Domicilio y Contacto para poder crear el nuevo Alumno:
        em.getTransaction().begin();
        em.persist(alumno);
        em.getTransaction().commit();

        System.out.println("Alumno " + alumno);
    }
}
