package session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SessionInicializacion {
    
    private static EntityManagerFactory emf = null;

    public static EntityManager getEntityManager() {
        emf = Persistence.createEntityManagerFactory("UnitBiblioteca");
        return emf.createEntityManager();
    }

    public static void truncadoParcial() throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            String sql = "TRUNCATE TABLE prestamo, deuda";
            em.createNativeQuery(sql).executeUpdate();
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(ex);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public static void truncadoTotal() throws Exception{
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            String sql = "TRUNCATE TABLE prestamo, deuda, libro, editor, lector, config";
            em.createNativeQuery(sql).executeUpdate();
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(ex);
        } finally {
            if (em != null) {
                em.close();
            }
        }
         
    }
    
}
