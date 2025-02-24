package gm.DAO;

import gm.entidad.Asignacion;
import jakarta.persistence.Query;
import java.util.List;

public class AsignacionDAO extends GenericDAO{

    public List<Asignacion> listar(){
        String consulta = "SELECT a FROM Asignacion a";
        em = getEntityManager();
        Query query = em.createQuery(consulta);
        return query.getResultList();
    }

    public void insertar(Asignacion asignacion){
        try {
            em = getEntityManager();
            // Iniciamos la transacción necesaria para modificar la BD:
            em.getTransaction().begin();
            em.persist(asignacion);
            em.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if(em != null){
                em.close();
            }
        }
    }

    public void actualizar(Asignacion asignacion){
        try {
            em = getEntityManager();
            // Iniciamos la transacción necesaria para modificar la BD:
            em.getTransaction().begin();
            // Esta vez sincronizamos nuestros cambios con el registro existente en la BD:
            em.merge(asignacion);
            em.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if(em != null){
                em.close();
            }
        }
    }

    public void eliminar(Asignacion asignacion){
        try {
            em = getEntityManager();
            // Iniciamos la transacción necesaria para modificar la BD:
            em.getTransaction().begin();
            // Esta vez sincronizamos nuestros cambios con el registro existente en la BD:
            em.remove(em.merge(asignacion));
            em.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if(em != null){
                em.close();
            }
        }
    }

    public Asignacion buscarPorId(Asignacion asignacion) {
        em = getEntityManager();
        return em.find(Asignacion.class, asignacion.getIdAsignacion());
    }
}
