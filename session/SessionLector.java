package session;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidad.Lector;

public class SessionLector {

	private static EntityManagerFactory emf = null;

	public static EntityManager getEntityManager() {

		emf = Persistence.createEntityManagerFactory("UnitBiblioteca");
		return emf.createEntityManager();
	}

	public static void insertar(Lector lector) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(lector);
			em.getTransaction().commit();
		} catch (Exception ex) {
			throw new Exception(ex);
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public static Lector irAlUltimo() {
		EntityManager em = getEntityManager();
		try {
			Query q = em.createNativeQuery(
					"SELECT * FROM lector ORDER BY lec_codigo DESC",
					Lector.class);
			q.setMaxResults(1);
			return (Lector) q.getSingleResult();
		} finally {
			em.close();
		}
	}

	@SuppressWarnings("unchecked")
	public static List<Lector> obtenerListaLectorPorFiltro(String filtro) {
		EntityManager em = getEntityManager();
		try {
			Query q = em.createNativeQuery(
					"SELECT * from lector WHERE (UPPER(lec_nombre) LIKE '%"
							+ filtro
							+ "%' OR cast( lec_codigo as varchar) LIKE '"
							+ filtro + "%') ORDER by lec_codigo ASC",
					Lector.class);
			return q.getResultList();
		} finally {
			em.close();
		}
	}

	public static void editar(Lector lector) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			lector = em.merge(lector);
			em.getTransaction().commit();
		} catch (Exception ex) {
			throw new Exception(ex);
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public static void eliminar(Lector lector) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			try {
				lector = em.getReference(Lector.class, lector.getLecCodigo());
			} catch (EntityNotFoundException ex) {
				throw new Exception(ex);
			}
			em.remove(lector);
			em.getTransaction().commit();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public static Lector obtenerEditor(Lector lector) throws Exception {
		EntityManager em = getEntityManager();
		return em.find(Lector.class, lector.getLecCodigo());
	}

	@SuppressWarnings("unchecked")
	public static List<Lector> obtenerListaLector() {
		EntityManager em = getEntityManager();
		try {
			Query q = em.createNativeQuery(
					"SELECT * from lector ORDER BY lec_codigo ASC",
					Lector.class);
			return q.getResultList();
		} finally {
			em.close();
		}
	}

}
