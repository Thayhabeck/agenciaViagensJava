package agenciaviagens;

public class Cliente {
	
	private static int cont;
	private String nome;
	private String cpf;
	private String endereco;
	private String email;
	private String fone;
	private int codC = cont;

	public Cliente() {
		Cliente.cont++;
	}
	
	public int getCodC() {
		return codC;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}
}