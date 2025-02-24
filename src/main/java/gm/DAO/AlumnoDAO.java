package gm.DAO;

import gm.entidad.Alumno;
import jakarta.persistence.Query;
import java.util.List;

public class AlumnoDAO extends GenericDAO{

    public List<Alumno> listar(){
        String consulta = "SELECT a FROM Alumno a";
        em = getEntityManager();
        Query query = em.createQuery(consulta);
        return query.getResultList();
    }

    public void insertar(Alumno alumno){
        try {
            em = getEntityManager();
            // Iniciamos la transacción necesaria para modificar la BD:
            em.getTransaction().begin();
            em.persist(alumno);
            em.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if(em != null){
                em.close();
            }
        }
    }

    public void actualizar(Alumno alumno){
        try {
            em = getEntityManager();
            // Iniciamos la transacción necesaria para modificar la BD:
            em.getTransaction().begin();
            // Esta vez sincronizamos nuestros cambios con el registro existente en la BD:
            em.merge(alumno);
            em.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if(em != null){
                em.close();
            }
        }
    }

    public void eliminar(Alumno alumno){
        try {
            em = getEntityManager();
            // Iniciamos la transacción necesaria para modificar la BD:
            em.getTransaction().begin();
            // Esta vez sincronizamos nuestros cambios con el registro existente en la BD:
            em.remove(em.merge(alumno));
            em.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if(em != null){
                em.close();
            }
        }
    }

    public Alumno buscarPorId(Alumno alumno) {
        em = getEntityManager();
        return em.find(Alumno.class, alumno.getIdAlumno());
    }
}
