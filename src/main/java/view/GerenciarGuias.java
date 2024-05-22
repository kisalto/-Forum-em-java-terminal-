package view;

import java.util.Scanner;

import controller.JogoController;
import controller.PersonagemController;
import model.entities.Guia;
import model.entities.Usuario;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import model.services.GuiasUsuario;

public class GerenciarGuias {
	public static void gerenciarGuias(Usuario user) {
		GuiasUsuario guiasUsuario = new GuiasUsuario();
		Scanner teclado = new Scanner(System.in);

		boolean loop = true;

		while (loop) {
			System.out.println("1. Criar Guia");
			System.out.println("2. Seus Guias");
			System.out.println("0. Voltar");
			
			int opc = teclado.nextInt();
			teclado.nextLine();
			
			switch (opc) {
			case 1:
				criarGuia(user);
				break;
			case 2:
				if (user.getGuiasQnt() > 0)
					seusGuias(user);
				else
					System.out.println("nenhum guia encontrado");
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
	
	public static void criarGuia(Usuario user) {
		GuiasUsuario guiaUsuario = new GuiasUsuario();
		JogoController jogoController = new JogoController();
		PersonagemController personagemController = new PersonagemController();
		Guia guia= new Guia();
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedDate = currentDate.format(formatter);
		Scanner teclado = new Scanner(System.in);
		
		
		
		System.out.println("Digite o titulo");
		String titulo = teclado.nextLine();
		System.out.println("Digite a descrição");
		String descricao = teclado.nextLine();
		System.out.println("Digite o tipo");
		String tipo = teclado.nextLine();
		System.out.println("Entre com o link do video");
		String url = teclado.nextLine();
		
		System.out.println("Escolha o jogo");
		for (var x : jogoController.findAll())
			System.out.println(x.getId() + ". " + x.getNome());
		Long game = teclado.nextLong();
		teclado.nextLine();
		
		var jogo = jogoController.findJogoById(game);
		
		System.out.println("Escolha o personagem");
		for (var x : personagemController.findByGameId(game)) {
			System.out.println(x.getId() + ". " + x.getNome());
		}
		Long character = teclado.nextLong();
		teclado.nextLine();
		
		var personagem = personagemController.findPersonagemById(character);
		
		guia.setTitulo(titulo);
		guia.setDescricao(descricao);
		guia.setTipo(tipo);
		guia.setUrl(url);
		guia.setDataCr(formattedDate);
		guia.setJogo(jogo);
		guia.setPersonagem(personagem);
		guia.setUsuario(user);
		user.setGuiasQnt(user.getGuiasQnt()+1);
		
		guiaUsuario.criarGuia(guia);
		System.out.println("Guia Criado!");
		
	}

	public static void seusGuias(Usuario user) {
		GuiasUsuario guiasUsuario = new GuiasUsuario();
		Scanner teclado = new Scanner(System.in);

		boolean loop = true;
		
		while (loop) {
			System.out.println("Seus Guias: ");
			for (var x : guiasUsuario.guiasUsuario(user)) {
				System.out.println(x.getId() + ". " + x.getTitulo());
			}
			System.out.println("0. Voltar");

			int opc = teclado.nextInt();
			teclado.nextLine();

			if (opc == 0) {
				System.out.println("Voltando");
				break;
			}

			for (var x : guiasUsuario.guiasUsuario(user)) {
				System.out.println(x.getId() + ". " + x.getTitulo());
				if (opc == x.getId()) {
					opcoesGuia(x.getId());
					break;
				}
			}

		}
	}
	
	public static void opcoesGuia(Long id) {
		GuiasUsuario guiasUsuario = new GuiasUsuario();
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
				editarGuia(id);
				break;
			case 2:
				guiasUsuario.deletarGuia(id);
				loop = false;
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

	public static void editarGuia(Long id) {
		GuiasUsuario guiasUsuario = new GuiasUsuario();
		Guia guia = new Guia();
		Scanner teclado = new Scanner(System.in);

		boolean loop = true;

		while (loop) {
			guia = guiasUsuario.visualizarGuia(id);

			System.out.println("Escolha oq deseja mudar:");
			System.out.println("1. Titulo: " + guia.getTitulo());
			System.out.println("2. Descrição: " + guia.getDescricao());
			System.out.println("3. Tipo: " + guia.getTipo());
			System.out.println("4. Url: " + guia.getUrl());
			System.out.println("0. Terminar");

			int escolha = teclado.nextInt();
			teclado.nextLine();
			int confirmar;

			switch (escolha) {
			case 1:
				System.out.println("Digite o novo titulo: ");
				String titulo = teclado.nextLine();
				System.out.println("Alterar titulo?");
				System.out.println("De: " + guia.getTitulo());
				System.out.println("Para: " + titulo);
				System.out.println("1. Confirmar");
				System.out.println("0. Cancelar");

				confirmar = teclado.nextInt();
				teclado.nextLine();

				if (confirmar == 1) {
					guia.setTitulo(titulo);
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
				System.out.println("De: " + guia.getDescricao());
				System.out.println("Para: " + descricao);
				System.out.println("1. Confirmar");
				System.out.println("0. Cancelar");

				confirmar = teclado.nextInt();
				teclado.nextLine();

				if (confirmar == 1) {
					guia.setDescricao(descricao);
					System.out.println("Alterado com sucesso");
				} else if (confirmar == 0)
					System.out.println("Voltando");
				else
					System.out.println("Errou feio errou rude, agora volte");
				break;
			case 3:
				System.out.println("Digite o novo tipo: ");
				String tipo = teclado.nextLine();
				System.out.println("Alterar tipo?");
				System.out.println("De: " + guia.getTipo());
				System.out.println("Para: " + tipo);
				System.out.println("1. Confirmar");
				System.out.println("0. Cancelar");

				confirmar = teclado.nextInt();
				teclado.nextLine();

				if (confirmar == 1) {
					guia.setTipo(tipo);
					System.out.println("Alterado com sucesso");
				} else if (confirmar == 0)
					System.out.println("Voltando");
				else
					System.out.println("Errou feio errou rude, agora volte");
				break;
			case 4:
				System.out.println("Digite o novo URL: ");
				String url = teclado.nextLine();
				System.out.println("Alterar URL?");
				System.out.println("De: " + guia.getUrl());
				System.out.println("Para: " + url);
				System.out.println("1. Confirmar");
				System.out.println("0. Cancelar");

				confirmar = teclado.nextInt();
				teclado.nextLine();

				if (confirmar == 1) {
					guia.setUrl(url);
					System.out.println("Alterado com sucesso");
				} else if (confirmar == 0)
					System.out.println("Voltando");
				else
					System.out.println("Errou feio errou rude, agora volte");
				break;
			case 0:
				System.out.println("Terminando alterações");
				guiasUsuario.confirmarAlteracao(guia);
				loop = false;
				break;
			default:
				System.out.println("Errou feio errou rude, tenta novamente");
				break;
			}
		}
		
	}
	public static void guiasExistentes() {
		GuiasUsuario guiasUsuario = new GuiasUsuario();
		Scanner teclado = new Scanner(System.in);
		
		boolean loop = true;
		
		while (loop) {
			for (var x : guiasUsuario.guiasExistentes()) {
				System.out.println(x.getId() + " | " + x.getJogo().getNome() + " | " + x.getPersonagem().getNome() + " | " + x.getTitulo() + " | " + x.getTipo());
			}
			System.out.println("0. Voltar");

		
			Long opc = teclado.nextLong();
			teclado.nextLine();
			
			if (opc == 0) {
				System.out.println("Voltando");
				break;
			}
			System.out.println("");
			Guia guia = guiasUsuario.visualizarGuia(opc);
			System.out.println(guia.getTitulo());
			System.out.println(guia.getDataCr());
			System.out.println(guia.getJogo().getNome());
			System.out.println(guia.getPersonagem().getNome());
			System.out.println(guia.getTipo());
			System.out.println("********************************");
			System.out.println(guia.getDescricao());
			System.out.println("********************************");
			System.out.println("Video: " + guia.getUrl());
			System.out.println("Likes: " + guia.getLikes() + " - Dislikes: " + guia.getDislikes());
			System.out.println("Criado por: " + guia.getUsuario().getNickname());
			System.out.println("");
		}
	}
}
