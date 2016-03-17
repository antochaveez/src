package session;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidad.Config;
import entidad.Editor;


public class SessionConfiguracion {
    
    private static EntityManagerFactory emf = null;

    public static EntityManager getEntityManager() {

        emf = Persistence.createEntityManagerFactory("UnitBiblioteca");
        return emf.createEntityManager();
    }

    public static void insertar(Config config) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            //Anular el codigo para evitar un error el la base de datos
            config.setCfgCodigo(null);
            em.persist(config);
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(ex);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public static void editar(Config config) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            config = em.merge(config);
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(ex);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public static boolean existeConfiguracion() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNativeQuery(
                    "SELECT * from config");
            q.getSingleResult();
            return true;
        }
        catch(NoResultException nre){
            return false;
        }
        finally {
            em.close();
        }

    }

  
    public static Config obtenerConfiguracion() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNativeQuery(
                    "SELECT * from config", Config.class);
            return (Config) q.getSingleResult();
        } 
        catch(Exception e){
            throw e;
        }
        finally {
            em.close();
        }
    }
    
    /**
     *  Inserta una nueva configuracion si aun no existe ninguna, o, en caso
     *  de que exista una, la modifica
     * @param config
     * @throws Exception
     */
    public static void cambiarConfiguracion(Config config) throws Exception{

        if (existeConfiguracion()){
            Config configExistente = obtenerConfiguracion();
            /* Asignar el codigo de la configuracion existente a la 
               configuracion introducida, para evitar que se cree un
               nuevo registro*/
            config.setCfgCodigo(configExistente.getCfgCodigo());
            editar(config);
        } else {
            insertar(config);
        }
    }
    

}
