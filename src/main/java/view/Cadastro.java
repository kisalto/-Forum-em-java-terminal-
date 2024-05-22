package view;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import controller.UsuarioController;
import model.entities.Usuario;

public class Cadastro {
	UsuarioController usuarioController = new UsuarioController();
	
	public void cadastrarUsuario() {
		Usuario user = new Usuario();
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedDate = currentDate.format(formatter);
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Entre com seu apelido");
		String apelido = teclado.nextLine();
		System.out.println("Entre com seu id do Discord");
		String dcId = teclado.nextLine();
		System.out.println("Entre com seu email");
		String email = teclado.nextLine();
		System.out.println("Entre com sua senha");
		String password = teclado.nextLine();
		
		user.setNickname(apelido);
		user.setPassword(password);
		user.setDcId(dcId);
		user.setEmail(email);
		user.setDataReg(formattedDate);
		
		usuarioController.create(user);

	}
	
	public Usuario verificarUsuario(String apelido, String senha) {
		Usuario user = usuarioController.findUsuarioByName(apelido);
		if (user != null)
			return Login(user, senha);
		else {
			System.out.println("batata");
			return null;
		}
	}
	
	public Usuario Login(Usuario user, String senha) {
		if (user.getPassword().equals(senha)) {
			System.out.println("Login com sucesso!");
			return user;
		} else {
			System.out.println("Errou a senha");
			return null;
		}
	}
}
