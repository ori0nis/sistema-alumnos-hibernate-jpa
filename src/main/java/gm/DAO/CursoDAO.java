package gm.DAO;

import gm.entidad.Curso;
import jakarta.persistence.Query;
import java.util.List;

public class CursoDAO extends GenericDAO{

    public List<Curso> listar(){
        String consulta = "SELECT c FROM Curso c";
        em = getEntityManager();
        Query query = em.createQuery(consulta);
        return query.getResultList();
    }

    public void insertar(Curso curso){
        try {
            em = getEntityManager();
            // Iniciamos la transacción necesaria para modificar la BD:
            em.getTransaction().begin();
            em.persist(curso);
            em.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if(em != null){
                em.close();
            }
        }
    }

    public void actualizar(Curso curso){
        try {
            em = getEntityManager();
            // Iniciamos la transacción necesaria para modificar la BD:
            em.getTransaction().begin();
            // Esta vez sincronizamos nuestros cambios con el registro existente en la BD:
            em.merge(curso);
            em.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if(em != null){
                em.close();
            }
        }
    }

    public void eliminar(Curso curso){
        try {
            em = getEntityManager();
            // Iniciamos la transacción necesaria para modificar la BD:
            em.getTransaction().begin();
            // Esta vez sincronizamos nuestros cambios con el registro existente en la BD:
            em.remove(em.merge(curso));
            em.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if(em != null){
                em.close();
            }
        }
    }

    public Curso buscarPorId(Curso curso) {
        em = getEntityManager();
        return em.find(Curso.class, curso.getIdCurso());
    }
}
