package gm.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public abstract class GenericDAO {

    // Recordar: los métodos protected se pueden utilizar directamente en las clases hijas
    protected static EntityManager em;
    private static EntityManagerFactory emf;
    private static final String PU = "HibernateJpaPU";

    public GenericDAO(){
        if(emf == null){
            emf = Persistence.createEntityManagerFactory(PU);
        }
    }

    protected EntityManager getEntityManager(){
        if(em == null){
            em = emf.createEntityManager();
        }
        return em;
    }
}
