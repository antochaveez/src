package tableModale;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import entidad.Lector;

public class LectorTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	List<Lector> lecList = new ArrayList<>();

	@Override
	public int getColumnCount() {

		return 5;
	}

	@Override
	public int getRowCount() {

		return lecList.size();
	}

	public String getColumnName(int columnIndex) {

		if (columnIndex == 0) {
			return "Código";
		}

		if (columnIndex == 1) {
			return "Nombre";
		}

		if (columnIndex == 2) {
			return "Cédula";
		}
		if (columnIndex == 3) {
			return "Dirección";
		}
		if (columnIndex == 4) {
			return "Teléfono";
		}

		return "";
	}

	@Override
	public Object getValueAt(int fila, int columna) {
		Lector lec = lecList.get(fila);

		if (columna == 0) {
			return lec.getLecCodigo();
		}

		if (columna == 1) {
			return lec.getLecNombre().trim();

		}

		if (columna == 2) {
			return lec.getLecCedula();

		}
		if (columna == 3) {
			return lec.getLecDireccion();
		}
		if (columna == 4) {
			return lec.getLecTelefo();
		}

		return lec;

	}

	public List<Lector> getLecList() {
		return lecList;
	}

	public void setLecList(List<Lector> lecList) {
		this.lecList = lecList;
	}

}
