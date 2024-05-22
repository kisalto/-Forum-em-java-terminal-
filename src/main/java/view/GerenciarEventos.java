package view;

import java.util.Scanner;

import model.entities.Eventos;
import model.entities.Usuario;
import model.services.EventosUsuario;
import controller.JogoController;

public class GerenciarEventos {
	public static void gerenciarEventos(Usuario user) {
		Scanner teclado = new Scanner(System.in);
			
		boolean loop = true;
			
		while (loop) {
			System.out.println("1. Criar Evento");
			System.out.println("2. Seus Evento");
			System.out.println("0. Voltar");
				
			int opc = teclado.nextInt();
			teclado.nextLine();
				
			switch (opc) {
			case 1:
				criarEventos(user);
				break;
			case 2:
				if (user.getEventosQnt() > 0)
					seusEventos(user);
				else
					System.out.println("Nenhum guia encontrado");
				break;
			case 0:
				System.out.println("Voltando");
				loop = false;
				break;
			default:
				System.out.println("Errou feio errou rude, tenta novamente");
				break;
			}
		}
		
	}
		

	public static void criarEventos(Usuario user) {
		EventosUsuario eventosUsuario = new EventosUsuario();
		JogoController jogoController = new JogoController();
		Eventos evento = new Eventos();
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Digite o titulo");
		String titulo = teclado.nextLine();
		System.out.println("Digite a descrição");
		String descricao = teclado.nextLine();
		System.out.println("Informe a data (yyyy-MM-dd)");
		String data = teclado.nextLine();
		System.out.println("Escolha o jogo");
		for (var x : jogoController.findAll())
			System.out.println(x.getId() + ". " + x.getNome());
		Long game = teclado.nextLong();
		teclado.nextLine();
		
		var jogo = jogoController.findJogoById(game);
		System.out.println(jogo.getNome());
		
		evento.setTitulo(titulo);
		evento.setDescricao(descricao);
		evento.setDia(data);
		evento.setJogo(jogo);
		evento.setUsuario(user);
		user.setEventosQnt(user.getEventosQnt()+1);
		
		eventosUsuario.criarEvento(evento);
		System.out.println("Jogo Criado!");
		
	}
	
	public static void seusEventos(Usuario user) {
		EventosUsuario eventosUsuario = new EventosUsuario();
		Scanner teclado = new Scanner(System.in);
		
		boolean loop = true;

		while (loop) {
			System.out.println("Seus Eventos: ");
			for (var x : eventosUsuario.eventosUsuario(user)) {
				System.out.println(x.getId() + ". " + x.getTitulo());
			}
			System.out.println("0. Voltar");

			int opc = teclado.nextInt();
			teclado.nextLine();

			if (opc == 0) {
				System.out.println("Voltando");
				break;
			}

			for (var x : eventosUsuario.eventosUsuario(user)) {
				System.out.println(x.getId() + ". " + x.getTitulo());
				if (opc == x.getId()) {
					opcoesEvento(x.getId());
					break;
				}
			}

		}
	}
	
	public static void opcoesEvento(Long id) {
		EventosUsuario eventosUsuario = new EventosUsuario();
		Scanner teclado = new Scanner(System.in);

		boolean loop = true;

		while (loop) {
			System.out.println("1. Editar");
			System.out.println("2. Excluir");
			System.out.println("0. Voltar");

			int opc = teclado.nextInt();
			teclado.nextLine();

			switch (opc) {
			case 1:
				editarEvento(id);
				break;
			case 2:
				eventosUsuario.deletarEvento(id);
				break;
			case 0:
				System.out.println("Voltando");
				loop = false;
				break;
			default:
				System.out.println("Errou feio errou rude, tenta novamente");
				break;
			}
		}
		
	}

	public static void editarEvento(Long id) {
		EventosUsuario eventosUsuario = new EventosUsuario();
		Eventos Evento = new Eventos();
		Scanner teclado = new Scanner(System.in);

		boolean loop = true;

		while (loop) {
			Evento = eventosUsuario.visualizarEvento(id);

			System.out.println("Escolha oq deseja mudar:");
			System.out.println("1. Titulo: " + Evento.getTitulo());
			System.out.println("2. Descrição: " + Evento.getDescricao());
			System.out.println("3. data: " + Evento.getDia());
			System.out.println("0. Terminar");

			int escolha = teclado.nextInt();
			teclado.nextLine();
			int confirmar;

			switch (escolha) {
			case 1:
				System.out.println("Digite o novo titulo: ");
				String titulo = teclado.nextLine();
				System.out.println("Alterar titulo?");
				System.out.println("De: " + Evento.getTitulo());
				System.out.println("Para: " + titulo);
				System.out.println("1. Confirmar");
				System.out.println("0. Cancelar");

				confirmar = teclado.nextInt();
				teclado.nextLine();

				if (confirmar == 1) {
					Evento.setTitulo(titulo);
					System.out.println("Alterado com sucesso");
				} else if (confirmar == 0)
					System.out.println("Voltando");
				else
					System.out.println("Errou feio errou rude, agora volte");
				break;
			case 2:
				System.out.println("Digite o nova descrição: ");
				String descricao = teclado.nextLine();
				System.out.println("Alterar descrição?");
				System.out.println("De: " + Evento.getDescricao());
				System.out.println("Para: " + descricao);
				System.out.println("1. Confirmar");
				System.out.println("0. Cancelar");

				confirmar = teclado.nextInt();
				teclado.nextLine();

				if (confirmar == 1) {
					Evento.setDescricao(descricao);
					System.out.println("Alterado com sucesso");
				} else if (confirmar == 0)
					System.out.println("Voltando");
				else
					System.out.println("Errou feio errou rude, agora volte");
				break;
			case 3:
				System.out.println("Digite o nova data: ");
				String data = teclado.nextLine();
				System.out.println("Alterar descrição?");
				System.out.println("De: " + Evento.getDia());
				System.out.println("Para: " + data);
				System.out.println("1. Confirmar");
				System.out.println("0. Cancelar");
				
				confirmar = teclado.nextInt();
				teclado.nextLine();
				
				if (confirmar == 1) {
					Evento.setDia(data);
					System.out.println("Alterado com sucesso");
				} else if (confirmar == 0)
					System.out.println("Voltando");
				else
					System.out.println("Errou feio errou rude, agora volte");
				break;
			case 0:
				System.out.println("Terminando alterações");
				eventosUsuario.confirmarAlteracao(Evento);
				loop = false;
				break;
			default:
				System.out.println("Errou feio errou rude, tenta novamente");
				break;
			}
		}
		
	}
	
	public static void eventosExistentes() {
		EventosUsuario eventosUsuario = new EventosUsuario();
		Scanner teclado = new Scanner(System.in);
		
		boolean loop = true;
		
		while (loop) {
			for (var x : eventosUsuario.eventosExistentes()) {
				System.out.println(x.getId() + " - " + x.getDia() + " - " + x.getTitulo());
			}
			System.out.println("0. Voltar");

		
			Long opc = teclado.nextLong();
			teclado.nextLine();
			
			if (opc == 0) {
				System.out.println("Voltando");
				break;
			}
			System.out.println("");
			Eventos evento = eventosUsuario.visualizarEvento(opc);
			System.out.println(evento.getTitulo());
			System.out.println(evento.getDia());
			System.out.println(evento.getJogo().getNome());
			System.out.println("********************************");
			System.out.println(evento.getDescricao());
			System.out.println("********************************");
			System.out.println("Criado por: " + evento.getUsuario().getNickname());
			System.out.println("");
		}
		
	}
}
