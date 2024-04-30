
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
import logica.Consola;
import persistencia.exceptions.NonexistentEntityException;
import persistencia.exceptions.PreexistingEntityException;


public class ConsolaJpaController implements Serializable {

    public ConsolaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public ConsolaJpaController(){
        emf = Persistence.createEntityManagerFactory("wishList_PU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Consola consola) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(consola);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findConsola(consola.getNombre()) != null) {
                throw new PreexistingEntityException("Consola " + consola + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Consola consola) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            consola = em.merge(consola);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = consola.getNombre();
                if (findConsola(id) == null) {
                    throw new NonexistentEntityException("The consola with id " + id + " no longer exists.");
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
            Consola consola;
            try {
                consola = em.getReference(Consola.class, id);
                consola.getNombre();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The consola with id " + id + " no longer exists.", enfe);
            }
            em.remove(consola);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Consola> findConsolaEntities() {
        return findConsolaEntities(true, -1, -1);
    }

    public List<Consola> findConsolaEntities(int maxResults, int firstResult) {
        return findConsolaEntities(false, maxResults, firstResult);
    }

    private List<Consola> findConsolaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Consola.class));
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

    public Consola findConsola(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Consola.class, id);
        } finally {
            em.close();
        }
    }

    public int getConsolaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Consola> rt = cq.from(Consola.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
