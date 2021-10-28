package agenciaviagens;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Agencia {

	private Scanner read = new Scanner(System.in);
	private ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
	private ArrayList<Destino> listaDestinos = new ArrayList<Destino>();
	private ArrayList<Viagem> listaViagens = new ArrayList<Viagem>();
	private String opSN;
	private static int indexC = 0, indexD = 0, indexV = 0;
	NumberFormat moeda = NumberFormat.getCurrencyInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Agencia() {
	}

	public void cadastroCliente() {
		do {
			listaClientes.add(new Cliente());
			System.out.println("============================================");
			System.out.println("Digite os dados do Cliente " + indexC + ":");
			System.out.println("============================================");
			System.out.printf("NOME:");
			this.listaClientes.get(indexC).setNome(read.nextLine().toUpperCase());
			System.out.printf("CPF: ");
			this.listaClientes.get(indexC).setCpf(read.nextLine().toUpperCase());
			System.out.printf("E-MAIL: ");
			this.listaClientes.get(indexC).setEmail(read.nextLine().toUpperCase());
			System.out.printf("TELEFONE: ");
			this.listaClientes.get(indexC).setFone(read.nextLine().toUpperCase());
			System.out.printf("ENDEREÇO: ");
			listaClientes.get(indexC).setEndereco(read.nextLine().toUpperCase());
			System.out.println("============================================");
			System.out.println("=========== CLIENTE CADASTRADO =============");
			System.out.println("======== Codigo de identificação:" + indexC + " ========");
			System.out.println("============================================");
			indexC++;
			System.out.println("Deseja cadastrar outro Cliente (S/N)?");
			this.opSN = read.nextLine().toUpperCase();
			while (!opSN.equals("S") && !opSN.equals("N")) {
				System.out.println("============================================");
				System.out.println("============== OPÇÃO INVÁLIDA ==============");
				System.out.println("============================================");
				System.out.println("Digite S_Sim\tDigite N_Não");
				this.opSN = read.nextLine().toUpperCase();
			}
		} while (opSN.equals("S"));
		System.out.println("============================================");
		System.out.println("=========== CADASTRO FINALIZADO ============");
	}

	public void cadastroDestino() {
		String preco = "";
		do {
			listaDestinos.add(new Destino());
			System.out.println("============================================");
			System.out.println("Digite os dados do Destino" + indexD + ":");
			System.out.println("============================================");
			System.out.printf("CIDADE: ");
			this.listaDestinos.get(indexD).setCidade(read.nextLine().toUpperCase());
			System.out.printf("ESTADO: ");
			this.listaDestinos.get(indexD).setEstado(read.nextLine().toUpperCase());
			System.out.printf("PAÍS: ");
			this.listaDestinos.get(indexD).setPais(read.nextLine().toUpperCase());
			System.out.printf("PREÇO DA DIÁRIA (use . como separador decimal): ");
			try {
				preco = read.nextLine();
				this.listaDestinos.get(indexD).setPreco(Double.parseDouble(preco));
			} catch (NumberFormatException e) {
				preco = preco.replace(",",".");
				this.listaDestinos.get(indexD).setPreco(Double.parseDouble(preco));
			}
			System.out.println("============================================");
			System.out.println("=========== DESTINO CADASTRADO =============");
			System.out.println("======= Codigo de identificação: " + indexD + " =========");
			System.out.println("============================================");
			indexD++;
			System.out.println("Deseja cadastrar outro Destino (S/N)?");
			opSN = read.nextLine().toUpperCase();
			while (!opSN.equals("S") && !opSN.equals("N")) {
				System.out.println("============================================");
				System.out.println("============== OPÇÃO INVÁLIDA ==============");
				System.out.println("============================================");
				System.out.println("Digite S_Sim\tDigite N_Não");
				opSN = read.nextLine().toUpperCase();
			}
		} while (opSN.equals("S"));
		System.out.println("============================================");
		System.out.println("=========== CADASTRO FINALIZADO ============");
	}

	public void cadastroViagem() throws ParseException {
		if (indexC == 0) {
			System.out.println("============================================");
			System.out.println("===== CADASTRO DE VIAGEM INDISPONÍVEL ======");
			System.out.println("============================================");
			System.out.println("Ainda não há Clientes cadastrados na agência!");
			System.out.println("============================================");
		} else if (indexD == 0) {
			System.out.println("============================================");
			System.out.println("===== CADASTRO DE VIAGEM INDISPONÍVEL ======");
			System.out.println("============================================");
			System.out.println("Ainda não há Destinos cadastrados na agência!");
			System.out.println("============================================");
		} else {
			Date ida = null;
			Date volta = null;
			do {
				listaViagens.add(new Viagem());
				System.out.println("============================================");
				System.out.println("=============== VIAGEM No " + indexV + " ===============");
				System.out.println("============================================");
				System.out.println("Digite o código do Cliente viajante:");
				System.out.println("============================================");
				this.listarClientes();
				this.listaViagens.get(indexV).setCliente(listaClientes.get(Integer.parseInt(read.nextLine())));
				System.out.println("============================================");
				System.out.println("=============== VIAGEM No " + indexV + " ================");
				System.out.println("============================================");
				System.out.println("Viajante: " + this.listaViagens.get(indexV).getCliente().getNome());
				System.out.println("============================================");
				System.out.println("Digite a Data de Ida (dd/mm/aaaa):");
				try {
					this.listaViagens.get(indexV).setDataIda(read.nextLine());
					ida = sdf.parse(this.listaViagens.get(indexV).getDataIda());
				} catch (ParseException e) {
					System.out.println("============================================");
					System.out.println("============== DATA INVÁLIDA ===============");
					System.out.println("============================================");
					System.out.println("Digite a Data de Ida COMPLETA (dd/mm/aaaa):");
					this.listaViagens.get(indexV).setDataIda(read.nextLine());
					ida = sdf.parse(this.listaViagens.get(indexV).getDataIda());
				}
				System.out.println("============================================");
				System.out.println("Digite a Data de Volta (dd/mm/aaaa):");
				try {
					this.listaViagens.get(indexV).setDataVolta(read.nextLine());
					volta = sdf.parse(this.listaViagens.get(indexV).getDataVolta());
				} catch (ParseException e) {
					System.out.println("============================================");
					System.out.println("============== DATA INVÁLIDA ===============");
					System.out.println("============================================");
					System.out.println("Digite a Data de Volta COMPLETA (dd/mm/aaaa):");
					this.listaViagens.get(indexV).setDataVolta(read.nextLine());
					volta = sdf.parse(this.listaViagens.get(indexV).getDataVolta());
				}
				int dias = (int) ((volta.getTime() - ida.getTime())/(1000 * 60 * 60 * 24));
				this.listaViagens.get(indexV).setDiarias(dias);
				System.out.println("============================================");
				System.out.println("=============== VIAGEM No " + indexV + " ================");
				System.out.println("============================================");
				System.out.println("Ida: " + this.listaViagens.get(indexV).getDataIda() + "  --  Volta: "
						+ this.listaViagens.get(indexV).getDataVolta());
				System.out.println("============================================");
				System.out.println("=========== ADICIONAR DESTINO: ============");
				System.out.println("============================================");
				this.listarDestinos();
				System.out.println("============================================");
				System.out.println("Insira o código do destino,  para adicioná-lo à viagem Nro " + indexV + ":");
				System.out.println("============================================");
				this.listaViagens.get(indexV).setDestViagem(listaDestinos.get(Integer.parseInt(read.nextLine())));
				System.out.println("============================================");
				System.out.println("===== DESTINO ADICIONADO A VIAGEM " + indexV + " ========");
				System.out.println("============================================");
				System.out.println("Destino: " + listaViagens.get(indexV).getDestViagem().getDestCompleto());
				System.out.println("============================================");
				indexV++;
				System.out.println("Deseja cadastrar outra Viagem (S/N)?");
				opSN = read.nextLine().toUpperCase();
				while (!opSN.equals("S") && !opSN.equals("N")) {
					System.out.println("============================================");
					System.out.println("============== OPÇÃO INVÁLIDA ==============");
					System.out.println("============================================");
					System.out.println("Digite S_Sim\tDigite N_Não");
					opSN = read.nextLine().toUpperCase();
				}
			} while (opSN.equals("S"));
			System.out.println("============================================");
			System.out.println("=========== CADASTRO FINALIZADO ============");
		}
	}

	public void mostrarCliente(int i) {
		System.out.println("--------------------------------------------");
		System.out.println("Código: " + i + " == Cliente: " + this.listaClientes.get(i).getNome());
		System.out.println("--------------------------------------------");
	}

	public void mostrarDestino(int i) {
		System.out.println("--------------------------------------------");
		System.out.println("Código: " + i + " == Destino: " + this.listaDestinos.get(i).getDestCompleto());
		System.out.println("--------------------------------------------");
	}

	public void mostrarViagem(int i) throws ParseException {
		System.out.println("--------------------------------------------");
		System.out.println("==== Viagem Nro. " + i);
		System.out.println("     Cliente: " + listaViagens.get(i).getCliente().getNome());
		System.out.println("     Data de Ida: " + listaViagens.get(i).getDataIda());
		System.out.println("     Data de Volta: " + listaViagens.get(i).getDataVolta());
		System.out.println("     Destino: " + listaViagens.get(i).getDestViagem().getDestCompleto());
		System.out.println("     Preço: " + moeda.format(listaViagens.get(i).getPrecoTotal()));
		System.out.println("--------------------------------------------");

	}

	public void listarClientes() {
		if (indexC == 0) {
			System.out.println("============================================");
			System.out.println("==== LISTAGEM DE CLIENTE INDISPONÍVEL ======");
			System.out.println("Ainda não há Clientes cadastrados na agência!");
			System.out.println("============================================");
		} else {
			System.out.println("============================================");
			for (int i = 0; i < listaClientes.size(); i++) {
				this.mostrarCliente(i);
			}
		}
	}

	public void listarDestinos() {
		if (indexD == 0) {
			System.out.println("============================================");
			System.out.println("==== LISTAGEM DE CLIENTE INDISPONÍVEL ======");
			System.out.println("Ainda não há Destinos cadastrados na agência!");
			System.out.println("============================================");
		} else {
			System.out.println("============================================");
			for (int i = 0; i < listaDestinos.size(); i++) {
				this.mostrarDestino(i);
			}
		}
	}

	public void listarViagens() throws ParseException {
		if (indexV == 0) {
			System.out.println("============================================");
			System.out.println("==== LISTAGEM DE CLIENTE INDISPONÍVEL ======");
			System.out.println("Ainda não há Viagens cadastradas na agência!");
			System.out.println("============================================");
		} else {
			System.out.println("============================================");
			for (int i = 0; i < listaViagens.size(); i++) {
				this.mostrarViagem(i);
			}
		}
	}

	public void consultarCliente() throws ParseException {
		if (indexC == 0) {
			System.out.println("============================================");
			System.out.println("==== CONSULTA DE CLIENTE INDISPONÍVEL ======");
			System.out.println("Ainda não há Clientes cadastrados na agência!");
			System.out.println("============================================");
		} else if (indexV == 0) {
			System.out.println("============================================");
			System.out.println("==== CONSULTA DE CLIENTE INDISPONÍVEL ======");
			System.out.println("Ainda não há Viagens cadastrados na agência!");
			System.out.println("============================================");
		} else {
			System.out.println("============================================");
			System.out.println("Digite o nome do Cliente que deseja consultar: ");
			System.out.println("============================================");
			String nome = read.nextLine().toUpperCase();
			int j = 0;
			System.out.println("============================================");
			System.out.println("Viagens cadastradas para o Cliente " + nome + ": ");
			System.out.println("============================================");
			for (int i = 0; i < listaViagens.size(); i++) {
				if (nome.equals(listaViagens.get(i).getCliente().getNome())) {
					mostrarViagem(i);
				} else {
					j++;
				}
			}
			if (j == listaViagens.size()) {
				System.out.println("============================================");
				System.out.println("Nenhuma viagem cadastrada Para este cliente!");
			}
		}
	}

	public void consultarDestino() throws ParseException {

		if (indexD == 0) {
			System.out.println("============================================");
			System.out.println("==== CONSULTA DE DESTINO INDISPONÍVEL ======");
			System.out.println("Ainda não há Destinos cadastrados na agência!");
		} else if (indexV == 0) {
			System.out.println("============================================");
			System.out.println("==== CONSULTA DE DESTINO INDISPONÍVEL ======");
			System.out.println("Ainda não há Viagens cadastradas na agência!");
		} else {
			System.out.println("============================================");
			System.out.println("Digite a Cidade que deseja consultar: ");
			System.out.println("============================================");
			String cidade = read.nextLine().toUpperCase();
			System.out.println("============================================");
			int j = 0;
			System.out.println("============================================");
			System.out.println("Viagens cadastradas com o Destino " + cidade + ": ");
			System.out.println("============================================");
			for (int i = 0; i < listaViagens.size(); i++) {
				if (cidade.equals(listaViagens.get(i).getDestViagem().getCidade())) {
					mostrarViagem(i);
				} else {
					j++;
				}
			}
			if (j == listaViagens.size()) {
				System.out.println("============================================");
				System.out.println("Nenhuma viagem cadastrada contém este Destino!");
			}
		}
	}

	public void consultarViagem() throws ParseException {
		int num = 0;
		if (indexV == 0) {
			System.out.println("============================================");
			System.out.println("==== CONSULTA DE VIAGENS INDISPONÍVEL ======");
			System.out.println("Ainda não há Viagens cadastradas na agência!");
		} else {
			System.out.println("============================================");
			System.out.println("Digite o código (número) da viagem que deseja consultar: ");
			System.out.println("============================================");
			num = Integer.parseInt(read.nextLine());
			try {
				mostrarViagem(num);
			} catch (IndexOutOfBoundsException e) {
				System.out.println("============================================");
				System.out.println("==== CONSULTA DE VIAGENS INDISPONÍVEL ======");
				System.out.println("============================================");
				System.out.println("Não há nenhuma viagem cadastrada no código " + num + "!");
			} 
		}
	}
}
