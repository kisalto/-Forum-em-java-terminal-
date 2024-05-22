package controller;

import java.util.List;

import model.entities.Eventos;
import model.entities.Usuario;
import model.repositories.EventosRepository;

public class EventosController {

	private EventosRepository eventosRepository = new EventosRepository();
	
	public Eventos findEventoById(Long id) {
		return (Eventos) eventosRepository.findById(id);
	}
	
	public Usuario findEventoByName(String name) {
		return (Usuario) eventosRepository.findByName(name);
	}
	
	public List<Eventos> findAll(){
		return eventosRepository.findAll();
	}
	
	public List<Eventos> findByUser(Long id) {
		return eventosRepository.findByUser(id);
	}
	
	public void deleteEventos(Long id) {
		eventosRepository.delete(id);
	}
	
	public void updateById(Eventos Eventos) {
		eventosRepository.updateById(Eventos);
	}
	
	public Eventos create(Object object) {
		return (Eventos) eventosRepository.create(object);
	}
}
