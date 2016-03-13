package entidad;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lector")
public class Lector implements Serializable {

	private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "lec_codigo", unique = true, nullable = false)
		private Integer lecCodigo;
		@Column(name = "lec_nombre", length = 80)
		private String lecNombre;
		@Column(name = "lec_cedula", unique = true, nullable = false)
		private Integer lecCedula;
		@Column(name = "lec_direcc", length = 80)
		private String lecDireccion;
		@Column(name = "lec_telefo", length = 60)
		private String lecTelefo;
		
		public Lector() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		

		public Lector(Integer lecCodigo, String lecNombre, Integer lecCedula,
				String lecDireccion, String lecTelefo) {
			super();
			this.lecCodigo = lecCodigo;
			this.lecNombre = lecNombre;
			this.lecCedula = lecCedula;
			this.lecDireccion = lecDireccion;
			this.lecTelefo = lecTelefo;
		}



		public Integer getLecCodigo() {
			return lecCodigo;
		}

		public void setLecCodigo(Integer lecCodigo) {
			this.lecCodigo = lecCodigo;
		}

		public String getLecNombre() {
			return lecNombre;
		}

		public void setLecNombre(String lecNombre) {
			this.lecNombre = lecNombre;
		}

		public Integer getLecCedula() {
			return lecCedula;
		}

		public void setLecCedula(Integer lecCedula) {
			this.lecCedula = lecCedula;
		}

		public String getLecDireccion() {
			return lecDireccion;
		}

		public void setLecDireccion(String lecDireccion) {
			this.lecDireccion = lecDireccion;
		}

		public String getLecTelefo() {
			return lecTelefo;
		}

		public void setLecTelefo(String lecTelefo) {
			this.lecTelefo = lecTelefo;
		}

		@Override
		public String toString() {
			return "Lector [lecCodigo=" + lecCodigo + ", lecNombre="
					+ lecNombre + ", lecCedula=" + lecCedula
					+ ", lecDireccion=" + lecDireccion + ", lecTelefo="
					+ lecTelefo + "]";
		}
		
		
		
}		
