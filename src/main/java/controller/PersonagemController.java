package controller;

import java.util.List;

import model.entities.Personagem;
import model.entities.Usuario;
import model.repositories.PersonagemRepository;

public class PersonagemController {

	private PersonagemRepository personagemRepository = new PersonagemRepository();
	
	public Personagem findPersonagemById(Long id) {
		return (Personagem) personagemRepository.findById(id);
	}
	
	public Usuario findPersonagemByName(String name) {
		return (Usuario) personagemRepository.findByName(name);
	}
	
	public List<Personagem> findAll(){
		return personagemRepository.findAll();
	}
	
	public List<Personagem> findByGameId(Long id) {
		return personagemRepository.findByGameId(id);
	}
	
}
