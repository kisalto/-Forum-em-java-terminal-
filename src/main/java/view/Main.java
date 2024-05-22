package view;

import java.util.Scanner;

import model.entities.Usuario;
import controller.UsuarioController;

//nao sei como eu vou adaptar a minha ideia de uma pagina web para um terminal
//mas eu vou tentar fazer meu melhor pra ficar entendivel

public class Main {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Cadastro cadastro = new Cadastro();
		UsuarioController usuarioController = new UsuarioController();

		System.out.println("bem vind@!");
		
		boolean loop = true;
			
		while (loop) {
			System.out.println("1. Registro");
			System.out.println("2. Login");
			System.out.println("3. mostrar todos");
			System.out.println("4. achar por id");
			System.out.println("0. sair");
			System.out.println("Escolha uma opção:");
			int opc = teclado.nextInt();
			teclado.nextLine();
			switch (opc) {
			case 1:
				cadastro.cadastrarUsuario();
				break;
			case 2:
				System.out.println("Login: ");
				String apelido = teclado.nextLine();
				System.out.println("Senha: ");
				String senha = teclado.nextLine();
				var verificar = cadastro.verificarUsuario(apelido, senha);
				if (verificar != null) {
					Dashboard.inicio(verificar);
				}
				break;
			case 3:
				 for (var x : usuarioController.findAll()) { 
					 System.out.println("nickname: " + x.getNickname()); 
				}
				break;
			case 4:
				System.out.println("Digite o id:");
				Long id = teclado.nextLong();
				Usuario user = usuarioController.findUsuarioById(id);
				System.out.println("nickname: " + user.getNickname());
				break;
			case 0:
				System.out.println("falou");
				loop = false;
				break;
			default:
				System.out.println("Errou feio errou rude, tenta novamente");
				break;
			}
		}

	}

}
