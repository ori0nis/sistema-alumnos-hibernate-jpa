package gm.DAO;

import gm.entidad.Contacto;
import jakarta.persistence.Query;
import java.util.List;

public class ContactoDAO extends GenericDAO{

    public List<Contacto> listar(){
        String consulta = "SELECT c FROM Contacto c";
        em = getEntityManager();
        Query query = em.createQuery(consulta);
        return query.getResultList();
    }

    public void insertar(Contacto contacto){
        try {
            em = getEntityManager();
            // Iniciamos la transacción necesaria para modificar la BD:
            em.getTransaction().begin();
            em.persist(contacto);
            em.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if(em != null){
                em.close();
            }
        }
    }

    public void actualizar(Contacto contacto){
        try {
            em = getEntityManager();
            // Iniciamos la transacción necesaria para modificar la BD:
            em.getTransaction().begin();
            // Esta vez sincronizamos nuestros cambios con el registro existente en la BD:
            em.merge(contacto);
            em.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if(em != null){
                em.close();
            }
        }
    }

    public void eliminar(Contacto contacto){
        try {
            em = getEntityManager();
            // Iniciamos la transacción necesaria para modificar la BD:
            em.getTransaction().begin();
            // Esta vez sincronizamos nuestros cambios con el registro existente en la BD:
            em.remove(em.merge(contacto));
            em.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if(em != null){
                em.close();
            }
        }
    }

    public Contacto buscarPorId(Contacto contacto) {
        em = getEntityManager();
        return em.find(Contacto.class, contacto.getIdContacto());
    }
}
