package tableModale;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import entidad.Prestamo;

public class PrestamoTableModel extends AbstractTableModel {


		private static final long serialVersionUID = 1L;
		
		List<Prestamo> PreList = new ArrayList<>();
		
		
		

		@Override
		public int getColumnCount() {
			
			return 7;
		}

		@Override
		public int getRowCount() {
			
			return PreList.size();
		}
		
		public String getColumnName(int columnIndex) {

			if (columnIndex == 0) {
				return "Nro_Préstamo";
			}

			if (columnIndex == 1) {
				return "Fecha_Préstamo";
			}

			if (columnIndex == 2) {
				return "Lector";
			}
			if (columnIndex == 3) {
				return "Libro";
			}
			if (columnIndex == 4) {
				return "Ejemplar";
			}
			if (columnIndex == 5) {
				return "Fecha_Devolución";
			}
			if (columnIndex == 6) {
				return "Fecha_Recuperación";
			}

			return "";
		}

		@Override
		public Object getValueAt(int fila, int columna) {
			Prestamo pre = PreList.get(fila);
				
				if (columna == 0) {
					return pre.getPreNumero();
				}
		
				if (columna == 1) {
					return pre.getFecPre();
		
				}
		
				if (columna == 2) {
					return pre.getLector();
		
				}
				if (columna == 3) {
					return pre.getLibro();
				}
				if (columna == 4) {
					return pre.getPreNroEje();
				}
				if (columna == 5) {
					return pre.getPreFecDev();
				}
				
				if (columna == 6) {
					return pre.getPreFecDev();
					
				}
				
				return pre;
				
				
				
			
		}

		public List<Prestamo> getPreList() {
			return PreList;
		}

		public void setPreList(List<Prestamo> preList) {
			PreList = preList;
		}

}