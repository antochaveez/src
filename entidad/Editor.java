package entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "editor")
public class Editor implements Serializable {
private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "edi_codigo", unique = true, nullable = false)
		private Integer ediNumero;
		@Column(name = "edi_descri", length = 80)
		private String ediDescri;
		@Column(name = "edi_obse", length = 100)
		private String ediObse;
		
		public Editor() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Editor(Integer ediNumero, String ediDescri, String ediObse) {
			super();
			this.ediNumero = ediNumero;
			this.ediDescri = ediDescri;
			this.ediObse = ediObse;
		}

		public Integer getEdiNumero() {
			return ediNumero;
		}

		public void setEdiNumero(Integer ediNumero) {
			this.ediNumero = ediNumero;
		}

		public String getEdiDescri() {
			return ediDescri;
		}

		public void setEdiDescri(String ediDescri) {
			this.ediDescri = ediDescri;
		}

		public String getEdiObse() {
			return ediObse;
		}

		public void setEdiObse(String ediObse) {
			this.ediObse = ediObse;
		}

		@Override
		public String toString() {
			return "Editor [ediNumero=" + ediNumero + ", ediDescri="
					+ ediDescri + ", ediObse=" + ediObse + "]";
		}
		
		
}



