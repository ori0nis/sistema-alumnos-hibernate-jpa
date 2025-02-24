package gm.DAO;

import gm.entidad.Domicilio;
import jakarta.persistence.Query;
import java.util.List;

public class DomicilioDAO extends GenericDAO{

    public List<Domicilio> listar(){
        String consulta = "SELECT d FROM Domicilio d";
        em = getEntityManager();
        Query query = em.createQuery(consulta);
        return query.getResultList();
    }

    public void insertar(Domicilio domicilio){
        try {
            em = getEntityManager();
            // Iniciamos la transacción necesaria para modificar la BD:
            em.getTransaction().begin();
            em.persist(domicilio);
            em.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if(em != null){
                em.close();
            }
        }
    }

    public void actualizar(Domicilio domicilio){
        try {
            em = getEntityManager();
            // Iniciamos la transacción necesaria para modificar la BD:
            em.getTransaction().begin();
            // Esta vez sincronizamos nuestros cambios con el registro existente en la BD:
            em.merge(domicilio);
            em.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if(em != null){
                em.close();
            }
        }
    }

    public void eliminar(Domicilio domicilio){
        try {
            em = getEntityManager();
            // Iniciamos la transacción necesaria para modificar la BD:
            em.getTransaction().begin();
            // Esta vez sincronizamos nuestros cambios con el registro existente en la BD:
            em.remove(em.merge(domicilio));
            em.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if(em != null){
                em.close();
            }
        }
    }

    public Domicilio buscarPorId(Domicilio domicilio) {
        em = getEntityManager();
        return em.find(Domicilio.class, domicilio.getIdDomicilio());
    }
}
