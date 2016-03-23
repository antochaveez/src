package session;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidad.Editor;

public class SessionEditor {

	private static EntityManagerFactory emf = null;

	public static EntityManager getEntityManager() {

		emf = Persistence.createEntityManagerFactory("UnitBiblioteca");
		return emf.createEntityManager();
	}

	public static void insertar(Editor editor) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(editor);
			em.getTransaction().commit();
		} catch (Exception ex) {
			throw new Exception(ex);
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}
	
	public static Editor irAlUltimo() {
		EntityManager em = getEntityManager();
		try {
			Query q = em.createNativeQuery("SELECT * FROM editor ORDER BY edi_codigo DESC", Editor.class);
			q.setMaxResults(1);
			return (Editor) q.getSingleResult();	
		} finally {
			em.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static List<Editor> obtenerListaEditorPorFiltro(String filtro) {
		EntityManager em = getEntityManager();
		try {
			Query q = em.createNativeQuery("SELECT * from editor WHERE (UPPER(edi_descri) LIKE '%" + filtro + "%' OR cast( edi_codigo as varchar) LIKE '%" + filtro + "%') ORDER by edi_codigo ASC",Editor.class);
			return q.getResultList();
		} finally {
			em.close();
		}
	}
	
	public static void editar(Editor editor) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			editor = em.merge(editor);
			em.getTransaction().commit();
		} catch (Exception ex) {
			throw new Exception(ex);
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}
	
	public static void eliminar(Editor editor) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			try {
				editor = em.getReference(Editor.class, editor.getEdiNumero());
			} catch (EntityNotFoundException ex) {
				throw new Exception(ex);
			}
			em.remove(editor);
			em.getTransaction().commit();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}
	
	public static Editor obtenerEditor(Editor editor) throws Exception {
		EntityManager em = getEntityManager();
		return em.find(Editor.class, editor.getEdiNumero());
	}
	
	@SuppressWarnings("unchecked")
	public static List<Editor> obtenerListaEditor() {
		EntityManager em = getEntityManager();
		try {
			Query q = em.createNativeQuery(
					"SELECT * from editor ORDER BY edi_codigo ASC", Editor.class);
			return q.getResultList();
		} finally {
			em.close();
		}
	}

}
