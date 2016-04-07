package session;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidad.Prestamo;

public class SessionPrestamo {

	private static EntityManagerFactory emf = null;

	public static EntityManager getEntityManager() {

		emf = Persistence.createEntityManagerFactory("UnitBiblioteca");
		return emf.createEntityManager();
	}

	public static void insertar(Prestamo prestamo) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(prestamo);
			em.getTransaction().commit();
		} catch (Exception ex) {
			throw new Exception(ex);
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}
	
	public static Prestamo irAlUltimo() {
		EntityManager em = getEntityManager();
		try {
			Query q = em.createNativeQuery("SELECT * FROM prestamo ORDER BY pre_numero DESC", Prestamo.class);
			q.setMaxResults(1);
			return (Prestamo) q.getSingleResult();	
		} finally {
			em.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static List<Prestamo> obtenerListaPrestamoPorFiltro(String filtro) {
		EntityManager em = getEntityManager();
		try {
			Query q = em.createNativeQuery("SELECT * from prestamo, lector WHERE and lec_codigo = pre_codlec and (UPPER(lec_nombre) LIKE '%" + filtro + "%' OR cast( pre_numero as varchar) LIKE '%" + filtro + "%') ORDER by pre_numero ASC",Prestamo.class);
			return q.getResultList();
		} finally {
			em.close();
		}
	}
	
	public static void editar(Prestamo prestamo) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			prestamo = em.merge(prestamo);
			em.getTransaction().commit();
		} catch (Exception ex) {
			throw new Exception(ex);
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}
	
	public static void eliminar(Prestamo prestamo) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			try {
				prestamo = em.getReference(Prestamo.class, prestamo.getPreNumero());
			} catch (EntityNotFoundException ex) {
				throw new Exception(ex);
			}
			em.remove(prestamo);
			em.getTransaction().commit();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}
	
	public static Prestamo obtenerPrestamo(Prestamo prestamo) throws Exception {
		EntityManager em = getEntityManager();
		return em.find(Prestamo.class, prestamo.getPreNumero());
	}
	
	@SuppressWarnings("unchecked")
	public static List<Prestamo> obtenerListaPrestamo() {
		EntityManager em = getEntityManager();
		try {
			Query q = em.createNativeQuery(
					"SELECT * from prestamo ORDER BY pre_numero ASC", Prestamo.class);
			return q.getResultList();
		} finally {
			em.close();
		}
	}

}
