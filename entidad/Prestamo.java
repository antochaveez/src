package entidad;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "prestamo")
public class Prestamo implements Serializable {

	private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "pre_numero", unique = true)
		private Integer preNumero;
		@Column(name = "pre_fecpre")
		private Date fecPre;
		@ManyToOne
		@JoinColumn(name = "pre_codlec", unique = true, nullable = false)
		private Lector lector;
		@ManyToOne
		@JoinColumn(name = "pre_codlib", unique = true, nullable = false)
		private Libro libro;
		@Column(name = "pre_nroeje", unique = true, nullable = false)
		private Integer preNroEje;
		@Column(name = "pre_fecdev")
		private Date preFecDev;
		@Column(name = "pre_fecrec")
		private Date preFecRec;
		
		public Prestamo() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Integer getPreNumero() {
			return preNumero;
		}

		public void setPreNumero(Integer preNumero) {
			this.preNumero = preNumero;
		}

		public Date getFecPre() {
			return fecPre;
		}

		public void setFecPre(Date fecPre) {
			this.fecPre = fecPre;
		}


		public Integer getPreNroEje() {
			return preNroEje;
		}

		public void setPreNroEje(Integer preNroEje) {
			this.preNroEje = preNroEje;
		}

		public Date getPreFecDev() {
			return preFecDev;
		}

		public void setPreFecDev(Date preFecDev) {
			this.preFecDev = preFecDev;
		}

		public Date getPreFecRec() {
			return preFecRec;
		}

		public void setPreFecRec(Date preFecRec) {
			this.preFecRec = preFecRec;
		}

		@Override
		public String toString() {
			return "Prestamo [preNumero=" + preNumero + ", fecPre=" + fecPre
					+ ", preCodLec="+ ", preCodLib="  + ", preNroEje=" + preNroEje 
					+ ", preFecDev=" + preFecDev
					+ ", preFecRec=" + preFecRec + "]";
		}

		public Lector getLector() {
			return lector;
		}

		public void setLector(Lector lector) {
			this.lector = lector;
		}

		public Libro getLibro() {
			return libro;
		}

		public void setLibro(Libro libro) {
			this.libro = libro;
		}
		
		
		
		
		
		

}
