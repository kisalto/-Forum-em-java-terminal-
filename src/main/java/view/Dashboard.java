package view;

import java.util.Scanner;

import model.entities.Usuario;

public class Dashboard {
	
	public static void inicio(Usuario user) {
		Scanner teclado = new Scanner(System.in);
		
		boolean loop = true;
		
		while (loop) {
			System.out.println("Bem vindo " + user.getNickname());
			System.out.println("1. Gerenciar guia(s)");
			System.out.println("2. Gerenciar evento(s)");
			System.out.println("3. Usuario");
			System.out.println("4. Guias");
			System.out.println("5. Eventos");
			System.out.println("0. Sair");
			System.out.println("Escolha uma opção");
			int menu = teclado.nextInt();
			teclado.nextLine();
			switch (menu) {
			case 1:
				GerenciarGuias.gerenciarGuias(user);
				break;
			case 2:
				GerenciarEventos.gerenciarEventos(user);
				break;
			case 3:
				//gerenciarUsuario(user);
				break;
			case 4:
				GerenciarGuias.guiasExistentes();
				break;
			case 5:
				GerenciarEventos.eventosExistentes();
				break;
			case 0:
				System.out.println("Adeus");
				loop = false;
				break;
			default:
				System.out.println("Errou feio errou rude, tenta novamente");
				break;
			}
		}
	}
	
}
