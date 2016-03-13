package session;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidad.Libro;

public class SessionLibros {

	private static EntityManagerFactory emf = null;

	public static EntityManager getEntityManager() {

		emf = Persistence.createEntityManagerFactory("UnitBiblioteca");
		return emf.createEntityManager();
	}

	public static void insertar(Libro libro) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(libro);
			em.getTransaction().commit();
		} catch (Exception ex) {
			throw new Exception(ex);
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public static void editar(Libro libro) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			libro = em.merge(libro);
			em.getTransaction().commit();
		} catch (Exception ex) {
			throw new Exception(ex);
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public static void eliminar(Libro libro) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			try {
				libro = em.getReference(Libro.class, libro.getLibCodigo());
			} catch (EntityNotFoundException ex) {
				throw new Exception(ex);
			}
			em.remove(libro);
			em.getTransaction().commit();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public static Libro obtenerLibro(Libro libro) throws Exception {
		EntityManager em = getEntityManager();
		return em.find(Libro.class, libro.getLibCodigo());
	}

	@SuppressWarnings("unchecked")
	public static List<Libro> obtenerListaLibro() {
		EntityManager em = getEntityManager();
		try {
			Query q = em.createNativeQuery(
					"SELECT * from libro ORDER BY lib_codigo ASC", Libro.class);
			return q.getResultList();
		} finally {
			em.close();
		}
	}

}
