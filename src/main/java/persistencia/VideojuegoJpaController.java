
package persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.Videojuego;
import persistencia.exceptions.NonexistentEntityException;
import persistencia.exceptions.PreexistingEntityException;


public class VideojuegoJpaController implements Serializable {

    public VideojuegoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public VideojuegoJpaController(){
        emf = Persistence.createEntityManagerFactory("wishList_PU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Videojuego videojuego) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(videojuego);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findVideojuego(videojuego.getNombre()) != null) {
                throw new PreexistingEntityException("Videojuego " + videojuego + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Videojuego videojuego) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            videojuego = em.merge(videojuego);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = videojuego.getNombre();
                if (findVideojuego(id) == null) {
                    throw new NonexistentEntityException("The videojuego with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Videojuego videojuego;
            try {
                videojuego = em.getReference(Videojuego.class, id);
                videojuego.getNombre();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The videojuego with id " + id + " no longer exists.", enfe);
            }
            em.remove(videojuego);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Videojuego> findVideojuegoEntities() {
        return findVideojuegoEntities(true, -1, -1);
    }

    public List<Videojuego> findVideojuegoEntities(int maxResults, int firstResult) {
        return findVideojuegoEntities(false, maxResults, firstResult);
    }

    private List<Videojuego> findVideojuegoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Videojuego.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Videojuego findVideojuego(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Videojuego.class, id);
        } finally {
            em.close();
        }
    }

    public int getVideojuegoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Videojuego> rt = cq.from(Videojuego.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
