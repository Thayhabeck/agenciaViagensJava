package agenciaviagens;

import java.text.ParseException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		Scanner read = new Scanner(System.in);
		Agencia habeck = new Agencia();
		String opMenu, opDados;

		System.out.println("=========BEM VINDO A HABECK TURISMO=========");
		do {
			System.out.println("====================MENU====================");
			System.out.println("Digite a opção desejada:");
			System.out.printf("0_Fechar Programa\t" + "1_Cadastrar Clientes\n" + "2_Cadastrar Destinos\t"
							+ "3_Cadastrar Viagem\n" + "4_Consultar Viagem\t" + "5_Listar Dados\n==>");
			opMenu = read.nextLine();
			while (!opMenu.equals("0") && !opMenu.equals("1") && !opMenu.equals("2") && !opMenu.equals("3")
					&& !opMenu.equals("4") && !opMenu.equals("5")) {
				System.out.println("--------------------------------------------");
				System.out.println("===============OPÇÃO INVÁLIDA===============");
				System.out.println("Digite a opção desejada:");
				System.out.printf("0_Fechar Programa\t" + "1_Cadastrar Clientes\n" + "2_Cadastrar Destinos\t"
								+ "3_Cadastrar Viagem\n" + "4_Consultar Dados\t" + "5_Listar Dados\n==>");
				opMenu = read.nextLine();
			}
			switch (opMenu) {
			case "1":
				habeck.cadastroCliente();
				break;

			case "2":
				habeck.cadastroDestino();
				break;
				
			case "3":
				habeck.cadastroViagem();
				break;
				
			case "4":
				System.out.println("--------------------------------------------");
				System.out.println("Digite a opção que deseja consultar: ");
				System.out.printf("A_Cliente\t" + "B_Destino\t" + "C_Viagem\n");
				opDados = read.nextLine().toUpperCase();
				while (!opDados.equals("A") && !opDados.equals("B") && !opDados.equals("C")) {
					System.out.println("--------------------------------------------");
					System.out.println("===============OPÇÃO INVÁLIDA===============");
					System.out.println("Digite a opção que deseja consultar: ");
					System.out.printf("A_Cliente\t" + "B_Destino\t" + "C_Viagem\n");
					opDados = read.nextLine().toUpperCase();
				}
					
				if (opDados.equals("A")) {
					habeck.consultarCliente();
				} else if (opDados.equals("B")) {
					habeck.consultarDestino();
				} else {
					habeck.consultarViagem();
				}
				break;
				
			case "5":
				System.out.println("--------------------------------------------");
				System.out.println("Digite a opção que deseja listar: ");
				System.out.printf("A_Cliente\t" + "B_Destino\t" + "C_Viagem\n");
				opDados = read.nextLine().toUpperCase();
				while (!opDados.equals("A") && !opDados.equals("B") && !opDados.equals("C")) {
					System.out.println("--------------------------------------------");
					System.out.println("===============OPÇÃO INVÁLIDA===============");
					System.out.println("Digite a opção que deseja listar: ");
					System.out.printf("A_Cliente\t" + "B_Destino\t" + "C_Viagem\n");
					opDados = read.nextLine().toUpperCase();
				}
				if (opDados.equals("A")) {
					habeck.listarClientes();
				} else if (opDados.equals("B")) {
					habeck.listarDestinos();
				} else {
					habeck.listarViagens();
				}
				break;
			}

		} while (!opMenu.equals("0"));
		System.out.println("-----------OBRIGADO POR ESCOLHER A HABECK TURISMO----------");
		System.out.println("-------------------Thayná Habeck_Diretora------------------");
		read.close();
	}

}
