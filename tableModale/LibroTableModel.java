package tableModale;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import entidad.Libro;

public class LibroTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	List<Libro> libList = new ArrayList<>();
	
	
	

	@Override
	public int getColumnCount() {
		
		return 7;
	}

	@Override
	public int getRowCount() {
		
		return libList.size();
	}
	
	public String getColumnName(int columnIndex) {

		if (columnIndex == 0) {
			return "Código";
		}

		if (columnIndex == 1) {
			return "Descripción";
		}

		if (columnIndex == 2) {
			return "Editorial";
		}
		if (columnIndex == 3) {
			return "Autor";
		}
		if (columnIndex == 4) {
			return "Isbn";
		}
		if (columnIndex == 5) {
			return "Observación";
		}
		if (columnIndex == 6) {
			return "Cod.Editorial";
		}

		return "";
	}

	@Override
	public Object getValueAt(int fila, int columna) {
		Libro lib = libList.get(fila);
			
			if (columna == 0) {
				return lib.getLibCodigo();
			}
	
			if (columna == 1) {
				return lib.getLibDescri().trim();
	
			}
	
			if (columna == 2) {
				return lib.getEditor();
	
			}
			if (columna == 3) {
				return lib.getLibAutor();
			}
			if (columna == 4) {
				return lib.getLibIsbn();
			}
			if (columna == 5) {
				return lib.getLibObse().trim();
			}
			
			if (columna == 6) {
				return lib.getEditor().getEdiNumero();
				
			}
			
			return lib;
			
		
	}

	public List<Libro> getLibList() {
		return libList;
	}

	public void setLibList(List<Libro> libList) {
		this.libList = libList;
	}

}
