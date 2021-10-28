package agenciaviagens;

import java.text.ParseException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		Scanner read = new Scanner(System.in);
		Agencia habeck = new Agencia();
		String opMenu, opDados;
		System.out.println("============================================");
		System.out.println("=======  BEM VINDO A HABECK TURISMO  =======");
		do {
			System.out.println("============================================");
			System.out.println("==================  MENU  ==================");
			System.out.println("============================================");
			System.out.println("  [0]_Fechar Programa");
			System.out.println("  [1]_Cadastrar Clientes");
			System.out.println("  [2]_Cadastrar Destinos");
			System.out.println("  [3]_Cadastrar Viagem");
			System.out.println("  [4]_Consultar Viagem");
			System.out.println("  [5]_Listar Dados");
			System.out.println("============================================");
			System.out.println("Digite a opção desejada:");
			opMenu = read.nextLine();
			while (!opMenu.equals("0") && !opMenu.equals("1") && !opMenu.equals("2") && !opMenu.equals("3")
					&& !opMenu.equals("4") && !opMenu.equals("5")) {
				System.out.println("============================================");
				System.out.println("=============  OPÇÃO INVÁLIDA  =============");
				System.out.println("============================================");
				System.out.println("  [0]_Fechar Programa");
				System.out.println("  [1]_Cadastrar Clientes");
				System.out.println("  [2]_Cadastrar Destinos");
				System.out.println("  [3]_Cadastrar Viagem");
				System.out.println("  [4]_Consultar Viagem");
				System.out.println("  [5]_Listar Dados");
				System.out.println("============================================");
				System.out.println("Digite a opção desejada:");
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
				System.out.println("============================================");
				System.out.println("  Digite a opção que deseja consultar: ");
				System.out.println("============================================");
				System.out.printf("A_Cliente\t" + "B_Destino\t" + "C_Viagem\n");
				opDados = read.nextLine().toUpperCase();
				while (!opDados.equals("A") && !opDados.equals("B") && !opDados.equals("C")) {
					System.out.println("============================================");
					System.out.println("=============  OPÇÃO INVÁLIDA  =============");
					System.out.println("============================================");
					System.out.println("  Digite a opção que deseja consultar: ");
					System.out.println("============================================");
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
				System.out.println("============================================");
				System.out.println("Digite a opção que deseja listar: ");
				System.out.println("============================================");
				System.out.printf("A_Cliente\t" + "B_Destino\t" + "C_Viagem\n");
				opDados = read.nextLine().toUpperCase();
				while (!opDados.equals("A") && !opDados.equals("B") && !opDados.equals("C")) {
					System.out.println("============================================");
					System.out.println("=============  OPÇÃO INVÁLIDA  =============");
					System.out.println("============================================");
					System.out.println("Digite a opção que deseja listar: ");
					System.out.println("============================================");
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
		System.out.println("============================================");
		System.out.println("=  OBRIGADO POR ESCOLHER A HABECK TURISMO  =");
		System.out.println("=========  Thayná Habeck_Diretora  =========");
		System.out.println("============================================");
		read.close();
	}

}
