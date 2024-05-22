package controller;

import java.util.List;

import model.entities.Guia;
import model.entities.Usuario;
import model.repositories.GuiaRepository;

public class GuiaController {

	private GuiaRepository guiaRepository = new GuiaRepository();
	
	public Guia findGuiaById(Long id) {
		return (Guia) guiaRepository.findById(id);
	}
	
	public Usuario findGuiaByName(String name) {
		return (Usuario) guiaRepository.findByName(name);
	}
	
	public List<Guia> findAll(){
		return guiaRepository.findAll();
	}
	
	public List<Guia> findByUser(Long id) {
		return guiaRepository.findByUser(id);
	}
	
	public void deleteGuia(Long id) {
		guiaRepository.delete(id);
	}
	
	public void updateById(Guia guia) {
		guiaRepository.updateById(guia);
	}
	
	public Guia create(Object object) {
		return (Guia) guiaRepository.create(object);
	}
	
}
