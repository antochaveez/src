package entidad;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "libro")
public class Libro implements Serializable {

	private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "lib_codigo", unique = true, nullable = false)
		private Integer libCodigo;
		@Column(name = "lib_descri", length = 100)
		private String libDescri;
		
		@ManyToOne
		@JoinColumn(name = "lib_codedi", unique = true, nullable = false)
		private Editor editor;
		
		@Column(name = "lib_autor", length = 200)
		private String libAutor;
		@Column(name = "lib_isbn", length = 30)
		private String libIsbn;
		@Column(name = "lib_obse", length = 100)
		private String libObse;
		
		public Libro() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Libro(Integer libCodigo, String libDescri, Editor editor,
				String libAutor, String libIsbn, String libObse) {
			super();
			this.libCodigo = libCodigo;
			this.libDescri = libDescri;
			this.editor = editor;
			this.libAutor = libAutor;
			this.libIsbn = libIsbn;
			this.libObse = libObse;
		}

		public Integer getLibCodigo() {
			return libCodigo;
		}

		public void setLibCodigo(Integer libCodigo) {
			this.libCodigo = libCodigo;
		}

		public String getLibDescri() {
			return libDescri;
		}

		public void setLibDescri(String libDescri) {
			this.libDescri = libDescri;
		}

		public Editor getEditor() {
			return editor;
		}

		public void setEditor(Editor editor) {
			this.editor = editor;
		}

		public String getLibAutor() {
			return libAutor;
		}

		public void setLibAutor(String libAutor) {
			this.libAutor = libAutor;
		}

		public String getLibIsbn() {
			return libIsbn;
		}

		public void setLibIsbn(String libIsbn) {
			this.libIsbn = libIsbn;
		}

		public String getLibObse() {
			return libObse;
		}

		public void setLibObse(String libObse) {
			this.libObse = libObse;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		@Override
		public String toString() {
			return "Libro [libCodigo=" + libCodigo + ", libDescri=" + libDescri
					+ ", editor=" + editor + ", libAutor=" + libAutor
					+ ", libIsbn=" + libIsbn + ", libObse=" + libObse + "]";
		}
		
		
		

		
		
		
		
		

		
}
