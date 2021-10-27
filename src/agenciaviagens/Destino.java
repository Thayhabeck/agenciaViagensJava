package agenciaviagens;


public class Destino {
		
		private String cidade;
		private String estado;
		private String pais;
		private String destCompleto;
		private double preco;

		public Destino() {
		}
		
		public Destino(String cidade, String estado, String pais, double preco) {
			this.cidade = cidade;
			this.estado = estado;
			this.pais = pais;
			this.preco = preco;
		}
		
		public String getDestCompleto() {
			this.destCompleto = this.cidade + " - " + this.estado + " - " + this.pais;
			return this.destCompleto;
		}
		
		
		public String getCidade() {
			return cidade;
		}

		public void setCidade(String cidade) {
			this.cidade = cidade;
		}

		public String getEstado() {
			return estado;
		}

		public void setEstado(String estado) {
			this.estado = estado;
		}

		public String getPais() {
			return pais;
		}

		public void setPais(String pais) {
			this.pais = pais;
		}

		public double getPreco() {
			return preco;
		}

		public void setPreco(double preco) {
			this.preco = preco;
		}
	}
