package agenciaviagens;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Agencia {

	private Scanner read = new Scanner(System.in);
	private ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
	private ArrayList<Destino> listaDestinos = new ArrayList<Destino>();
	private ArrayList<Viagem> listaViagens = new ArrayList<Viagem>();
	private String opSN;
	private static int indexC = 0, indexD = 0, indexV = 0;
	NumberFormat moeda = NumberFormat.getCurrencyInstance();

	public Agencia() {
	}

	public void cadastroCliente() {
		do {
			listaClientes.add(new Cliente());
			System.out.printf("\n--------------------------------------------\n" 
							+ "Digite os dados do Cliente %d:\n" + "NOME: ", indexC);
			this.listaClientes.get(indexC).setNome(read.nextLine().toUpperCase());
			System.out.printf("CPF: ");
			this.listaClientes.get(indexC).setCpf(read.nextLine().toUpperCase());
			System.out.printf("E-MAIL: ");
			this.listaClientes.get(indexC).setEmail(read.nextLine().toUpperCase());
			System.out.printf("TELEFONE: ");
			this.listaClientes.get(indexC).setFone(read.nextLine().toUpperCase());
			System.out.printf("ENDEREÇO: ");
			listaClientes.get(indexC).setEndereco(read.nextLine().toUpperCase());
			System.out.printf("--------------------------------------------\n" 
							+ "------------CLIENTE CADASTRADO--------------\n"
							+ "---------Codigo de identificação: %d--------\n", indexC);
			indexC++;
			System.out.println("Deseja cadastrar outro Cliente (S/N)?");
			this.opSN = read.nextLine().toUpperCase();
			while (!opSN.equals("S") && !opSN.equals("N")) {
				System.out.println("===============OPÇÃO INVÁLIDA===============");
				System.out.println("Digite S_Sim\tDigite N_Não");
				this.opSN = read.nextLine().toUpperCase();
			}
		} while (opSN.equals("S"));
		System.out.println("------------CADASTRO FINALIZADO-------------");
	}

	public void cadastroDestino() {
		do {
			listaDestinos.add(new Destino());
			System.out.printf("\n--------------------------------------------\n" 
							+ "Digite os dados do Destino %d:\n"
							+ "CIDADE: ", indexD);
			this.listaDestinos.get(indexD).setCidade(read.nextLine().toUpperCase());
			System.out.printf("ESTADO: ");
			this.listaDestinos.get(indexD).setEstado(read.nextLine().toUpperCase());
			System.out.printf("PAÍS: ");
			this.listaDestinos.get(indexD).setPais(read.nextLine().toUpperCase());
			System.out.printf("PREÇO DA DIÁRIA (use . como separador decimal): ");
			this.listaDestinos.get(indexD).setPreco(Double.parseDouble(read.nextLine()));
			System.out.printf("--------------------------------------------\n" 
							+ "------------DESTINO CADASTRADO--------------\n"
							+ "---------Codigo de identificação: %d--------\n", indexD);
			indexD++;
			System.out.println("Deseja cadastrar outro Destino (S/N)?");
			opSN = read.nextLine().toUpperCase();
			while (!opSN.equals("S") && !opSN.equals("N")) {
				System.out.println("===============OPÇÃO INVÁLIDA===============");
				System.out.println("Digite S_Sim\tDigite N_Não");
				opSN = read.nextLine().toUpperCase();
			}
		} while (opSN.equals("S"));
		System.out.println("------------CADASTRO FINALIZADO-------------");
	}

	public void cadastroViagem() {
		if (indexC == 0) {
			System.out.printf("\n--------------------------------------------\n"
							+ "------CADASTRO DE VIAGEM INDISPONÍVEL-------\n"
							+ "Ainda não há Clientes cadastrados na agência!\n");
		} else if (indexD == 0) {
			System.out.printf("\n--------------------------------------------\n"
							+ "------CADASTRO DE VIAGEM INDISPONÍVEL-------\n"
							+ "Ainda não há Destinos cadastrados na agência!\n");
		} else {
			do {
			listaViagens.add(new Viagem());
			System.out.printf("\n--------------------------------------------\n"
							+ "================VIAGEM No %d================\n", indexV);
			System.out.println("Digite o código do Cliente viajante:");
			this.listarClientes();
			this.listaViagens.get(indexV).setCliente(listaClientes.get(Integer.parseInt(read.nextLine())));
			System.out.printf("================VIAGEM No %d================\n" 
							+ "Viajante: %s\n"
							+ "--------------------------------------------\n",
					indexV, this.listaViagens.get(indexV).getCliente().getNome());
			System.out.println("Digite a Data de Ida (dd/mm/aaaa):");
			this.listaViagens.get(indexV).setDataIda(read.nextLine());
			System.out.println("Digite a Data de Volta (dd/mm/aaaa):");
			this.listaViagens.get(indexV).setDataVolta(read.nextLine());
			System.out.printf("================VIAGEM No %d================\n" 
							+ "Ida: %s\t Volta: %s\n"
							+ "--------------------------------------------\n",
							indexV, this.listaViagens.get(indexV).getDataIda(), this.listaViagens.get(indexV).getDataVolta());
				System.out.println("============ADICIONAR DESTINO:=============");
				this.listarDestinos();
				System.out.println("--------------------------------------------");
				System.out.println("Insira o código do destino,  para adicionalo à viagem Nro " + indexV + ":");
				this.listaViagens.get(indexV).setDestViagem(listaDestinos.get(Integer.parseInt(read.nextLine())));
				System.out.printf("--------------------------------------------\n"
								+ "------DESTINO ADICIONADO A VIAGEM %d--------\n"
								+ "===> %s\n", indexV, listaViagens.get(indexV).getDestViagem().getDestCompleto());
				indexV++;
				System.out.println("Deseja cadastrar outra Viagem (S/N)?");
				opSN = read.nextLine().toUpperCase();
				while (!opSN.equals("S") && !opSN.equals("N")) {
					System.out.println("===============OPÇÃO INVÁLIDA===============");
					System.out.println("Digite S_Sim\tDigite N_Não");
					opSN = read.nextLine().toUpperCase();
				}
			} while (opSN.equals("S"));
			System.out.println("------------CADASTRO FINALIZADO-------------");
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
		System.out.println("====Viagem Nro. " + i);
		System.out.println("	Cliente: " + listaViagens.get(i).getCliente().getNome());
		System.out.println("    Data de Ida: " + listaViagens.get(i).getDataIda());
		System.out.println("    Data de Volta: " + listaViagens.get(i).getDataVolta());
		System.out.println("    Destino: " + listaViagens.get(i).getDestViagem().getDestCompleto());
		System.out.println("    Preço: " + moeda.format(listaViagens.get(i).getPrecoTotal()));
		

	}

	public void listarClientes() {
		if (indexC == 0) {
			System.out.printf("\n--------------------------------------------\n"
							+ "------LISTAGEM DE CLIENTE INDISPONÍVEL-------\n"
							+ "Ainda não há Clientes cadastrados na agência!\n");
		} else {
			System.out.println("============================================");
			for (int i = 0; i < listaClientes.size(); i++) {
				this.mostrarCliente(i);
			}
			System.out.println("============================================");
		}
	}

	public void listarDestinos() {
		if (indexD == 0) {
			System.out.printf("\n--------------------------------------------\n"
							+ "-----LISTAGEM DE DESTINO INDISPONÍVEL-------\n"
							+ "Ainda não há Destinos cadastrados na agência!\n");
		} else {
			System.out.println("============================================");
			for (int i = 0; i < listaDestinos.size(); i++) {
				this.mostrarDestino(i);
			}
			System.out.println("============================================");
		}
	}

	public void listarViagens() throws ParseException {
		if (indexV == 0) {
			System.out.printf("\n--------------------------------------------\n"
							+ "------LISTAGEM DE VIAGEM INDISPONÍVEL-------\n"
							+ "Ainda não há Viagens cadastrados na agência!\n");
		} else {
			System.out.println("============================================");
			for (int i = 0; i < listaViagens.size(); i++) {
				this.mostrarViagem(i);
			}
			System.out.println("============================================");
		}
	}
	
	public void consultarCliente() throws ParseException {
		if (indexC == 0) {
			System.out.printf("\n--------------------------------------------\n"
							+ "------CONSULTA DE CLIENTE INDISPONÍVEL------\n"
							+ "Ainda não há Clientes cadastrados na agência!\n");
		} else if (indexV == 0){
			System.out.printf("\n--------------------------------------------\n"
							+ "------CONSULTA DE CLIENTE INDISPONÍVEL------\n"
							+ "Ainda não há Viagens cadastradAs para exibir!\n");
		} else {
			System.out.println("Digite o nome do Cliente que deseja consultar: ");
			String nome = read.nextLine().toUpperCase();
			int j=0;
			System.out.println("============================================");
			System.out.println("Viagens cadastradas para o Cliente " + nome + ": ");
			for (int i = 0; i < listaViagens.size(); i++) {
				if (nome.equals(listaViagens.get(i).getCliente().getNome())) {
					mostrarViagem(i);
				} else {
					j++;
				}
			}
			if(j == listaViagens.size()) {
				System.out.println("============================================");
				System.out.println("Nenhuma viagem cadastrada Para este cliente!");
			}
		}
	}
	
	public void consultarDestino() throws ParseException {
		
		if (indexD == 0) {
			System.out.printf("\n--------------------------------------------\n"
							+ "------CONSULTA DE DESTINO INDISPONÍVEL------\n"
							+ "Ainda não há Destinos cadastrados na agência!\n");
		} else if (indexV == 0){
			System.out.printf("\n--------------------------------------------\n"
							+ "------CONSULTA DE DESTINO INDISPONÍVEL------\n"
							+ "Ainda não há Viagens cadastradAs para exibir!\n");
		} else {
			System.out.println("Digite a Cidade que deseja consultar: ");
			String cidade = read.nextLine().toUpperCase();
			System.out.println("============================================");
			int j=0;
			System.out.println("Viagens cadastradas com o Destino " + cidade + ": ");
			for (int i = 0; i < listaViagens.size(); i++) {
				if (cidade.equals(listaViagens.get(i).getDestViagem().getCidade())) {
					mostrarViagem(i);
				} else {
					j++;
				}
			}
			if(j == listaViagens.size()) {
				System.out.println("============================================");
				System.out.println("Nenhuma viagem cadastrada contém este Destino!");
			}
		}
	}
	
	public void consultarViagem() throws ParseException {
		
		if (indexV == 0){
			System.out.printf("\n--------------------------------------------\n"
							+ "------CONSULTA DE VIAGEM INDISPONÍVEL-------\n"
							+ "Ainda não há Viagens cadastradAs para exibir!\n");
		} else  {
			System.out.println("Digite o código (número) da viagem que deseja consultar: ");
			int num = Integer.parseInt(read.nextLine());
			if (num < listaViagens.size()) {
				System.out.printf("\n--------------------------------------------\n"
								+ "------CONSULTA DE VIAGEM INDISPONÍVEL-------\n"
								+ "Não há nenhuma viagem cadastrada no código " + num + "!\n");
			} else {
				mostrarViagem(num);
			}
		}
	}
}
