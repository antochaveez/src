package entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "deuda")
public class Deuda implements Serializable {

	private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "deu_numero", unique = true, nullable = false)
		private Integer deuNumero;
		@Column(name = "deu_codalu", unique = true)
		private Integer deuCodalu;
		@Column(name = "deu_nropre", unique = true)
		private Integer deuNroPre;
		@Column(name = "deu_monto")
		private Integer deuMonto;
		@Column(name = "deu_pagado")
		private Integer deuPagado;
		public Deuda() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Integer getDeuNumero() {
			return deuNumero;
		}
		public void setDeuNumero(Integer deuNumero) {
			this.deuNumero = deuNumero;
		}
		public Integer getDeuCodalu() {
			return deuCodalu;
		}
		public void setDeuCodalu(Integer deuCodalu) {
			this.deuCodalu = deuCodalu;
		}
		public Integer getDeuNroPre() {
			return deuNroPre;
		}
		public void setDeuNroPre(Integer deuNroPre) {
			this.deuNroPre = deuNroPre;
		}
		public Integer getDeuMonto() {
			return deuMonto;
		}
		public void setDeuMonto(Integer deuMonto) {
			this.deuMonto = deuMonto;
		}
		public Integer getDeuPagado() {
			return deuPagado;
		}
		public void setDeuPagado(Integer deuPagado) {
			this.deuPagado = deuPagado;
		}
		@Override
		public String toString() {
			return "Deuda [deuNumero=" + deuNumero + ", deuCodalu=" + deuCodalu
					+ ", deuNroPre=" + deuNroPre + ", deuMonto=" + deuMonto
					+ ", deuPagado=" + deuPagado + "]";
		}
		
		
		
}		