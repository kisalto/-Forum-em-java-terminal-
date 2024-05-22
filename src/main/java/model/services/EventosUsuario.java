package model.services;

import java.util.List;

import controller.EventosController;
import model.entities.Eventos;
import model.entities.Usuario;

public class EventosUsuario {
	EventosController eventoController = new EventosController();

	public List<Eventos> eventosUsuario(Usuario user) {
		List<Eventos> Evento = eventoController.findByUser(user.getId());
		return Evento;
	}

	public void deletarEvento(Long id) {
		eventoController.deleteEventos(id);
	}

	public Eventos visualizarEvento(Long id) {
		Eventos Evento = eventoController.findEventoById(id);
		return Evento;
	}

	public void confirmarAlteracao(Eventos Evento) {
		eventoController.updateById(Evento);
	}
	
	public void criarEvento(Eventos evento) {
		eventoController.create(evento);
	}
	
	public List<Eventos> eventosExistentes() {
		return eventoController.findAll();
	}

}
