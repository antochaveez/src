package test;

import java.util.List;

import session.SessionLibros;
import entidad.Editor;
import entidad.Libro;


public class PruebaLibro {

	public static void main(String[] args) throws Exception {
			
		pruebalista();
		pruebaModificar();
		pruebalista();	
		
	}
	
	public static void pruebaInsertar() throws Exception {
		Libro libro = new Libro();
		Editor editor = new Editor();
		editor.setEdiNumero(1);
		
		
		libro.setEditor(editor);
		libro.setLibAutor("Maria");
		libro.setLibDescri("accion");
		libro.setLibIsbn("1030");
		libro.setLibObse("largo");
		
		
		//JOptionPane.showMessageDialog(null, cliente);
		SessionLibros.insertar(libro);
		
	}
	
	
	
public static void pruebalista() throws Exception{
		
		List<Libro> lista = SessionLibros.obtenerListaLibro();
		for (Libro libro : lista) {
			System.out.println(libro);
		}
		
	}

public static void pruebaModificar() throws Exception {
	
	Editor editor = new Editor();
	editor.setEdiNumero(2);
	
	Libro libro = new Libro(2, "drama", editor, "Salchichon","1040", "deteriorado");
	 

	SessionLibros.editar(libro);
}

}
