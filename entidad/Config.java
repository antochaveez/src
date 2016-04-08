package entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "config")
public class Config implements Serializable {
private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		
		@Column(name = "cfg_codigo", unique = true)
		private Integer cfgCodigo;
		@Column(name = "cfg_orga", length = 100)
		private String cfgOrga;
		@Column(name = "cfg_deumor")
		private Integer cfgDeumor;
		@Column(name = "cfg_diamor")
		private Integer cfgDiamor;
		@Column(name = "cfg_diapre")
		private Integer cfgDiapre;
	    @Column(name = "cfg_pass")
	    private String cfgPass;
		
		public Config() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		public Config(String cfgOrga, Integer cfgDeumor, Integer cfgDiamor,
				Integer cfgDiapre, String cfgPass) {
			super();
			this.cfgOrga = cfgOrga;
			this.cfgDeumor = cfgDeumor;
			this.cfgDiamor = cfgDiamor;
			this.cfgDiapre = cfgDiapre;
			this.cfgPass = cfgPass;
		}


		public Config(String cfgOrga, Integer cfgDeumor, Integer cfgDiamor,
                            Integer cfgDiapre) {
            this.cfgOrga = cfgOrga;
            this.cfgDeumor = cfgDeumor;
            this.cfgDiamor = cfgDiamor;
            this.cfgDiapre = cfgDiapre;

        }


        public String getCfgPass() {
            return cfgPass;
        }


        public void setCfgPass(String cfgPass) {
            this.cfgPass = cfgPass;
        }


        public String getCfgOrga() {
			return cfgOrga;
		}

		public void setCfgOrga(String cfgOrga) {
			this.cfgOrga = cfgOrga;
		}

		public Integer getCfgDeumor() {
			return cfgDeumor;
		}

		public void setCfgDeumor(Integer cfgDeumor) {
			this.cfgDeumor = cfgDeumor;
		}

		public Integer getCfgDiamor() {
			return cfgDiamor;
		}

		public void setCfgDiamor(Integer cfgDiamor) {
			this.cfgDiamor = cfgDiamor;
		}

		public Integer getCfgDiapre() {
			return cfgDiapre;
		}

		public void setCfgDiapre(Integer cfgDiapre) {
			this.cfgDiapre = cfgDiapre;
		}


		@Override
        public String toString() {
            return "Config [cfgCodigo=" + cfgCodigo + ", cfgOrga=" + cfgOrga + ", cfgDeumor=" + cfgDeumor
                    + ", cfgDiamor=" + cfgDiamor + ", cfgDiapre=" + cfgDiapre + ", cfgPass=" + cfgPass + "]";
        }


        public Integer getCfgCodigo() {
			return cfgCodigo;
		}


		public void setCfgCodigo(Integer cfgCodigo) {
			this.cfgCodigo = cfgCodigo;
		}
		
		
		
}		
		