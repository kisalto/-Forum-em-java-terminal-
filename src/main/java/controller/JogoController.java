package controller;

import java.util.List;

import model.entities.Jogo;
import model.entities.Usuario;
import model.repositories.JogoRepository;

public class JogoController {

	private JogoRepository jogoRepository = new JogoRepository();
	
	public Jogo findJogoById(Long id) {
		return (Jogo) jogoRepository.findById(id);
	}
	
	public Usuario findJogoByName(String name) {
		return (Usuario) jogoRepository.findByName(name);
	}
	
	public List<Jogo> findAll(){
		return jogoRepository.findAll();
	}
	
}
