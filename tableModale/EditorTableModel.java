package tableModale;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import entidad.Editor;



public class EditorTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	List<Editor> edList = new ArrayList<>();

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public int getRowCount() {
		
		return edList.size();
	}
	
	@Override
	public String getColumnName(int columnIndex) {

		if (columnIndex == 0) {
			return "Codigo";
		}

		if (columnIndex == 1) {
			return "Descripcion";
		}

		if (columnIndex == 2) {
			return "Observacion";
		}

		return "";
	}

	@Override
	public Object getValueAt(int fila, int columna) {
		
		Editor edit = edList.get(fila);
		
		if (columna == 0) {
			return edit.getEdiNumero();
		}

		if (columna == 1) {
			return edit.getEdiDescri().trim();

		}

		if (columna == 2) {
			return edit.getEdiObse().trim();

		}
		
		return edit;
	}

	public List<Editor> getEdList() {
		return edList;
	}

	public void setEdList(List<Editor> edList) {
		this.edList = edList;
	}
	
}
