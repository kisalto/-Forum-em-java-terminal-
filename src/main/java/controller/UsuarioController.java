package controller;

import java.util.List;

import model.entities.Usuario;
import model.repositories.UsuarioRepository;

public class UsuarioController {

	private UsuarioRepository usuarioRepository = new UsuarioRepository();
	
	public Usuario findUsuarioById(Long id) {
		return (Usuario) usuarioRepository.findById(id);
	}
	
	public Usuario findUsuarioByName(String name) {
		return (Usuario) usuarioRepository.findByName(name);
	}
	
	public List<Usuario> findAll() { 
		return usuarioRepository.findAll(); 
	}
	
	public Usuario create(Object object) {
		return (Usuario) usuarioRepository.create(object);
	}
}
