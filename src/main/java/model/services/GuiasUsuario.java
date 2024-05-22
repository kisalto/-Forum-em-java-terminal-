package model.services;

import java.util.List;

import controller.GuiaController;
import model.entities.Usuario;
import model.entities.Guia;

public class GuiasUsuario {
	GuiaController guiaController = new GuiaController();
	
	public List<Guia> guiasUsuario(Usuario user) {
		List<Guia> guia = guiaController.findByUser(user.getId());
		return guia;
	}
	
	public void deletarGuia(Long id) {
		guiaController.deleteGuia(id);
	}
	public Guia visualizarGuia(Long id) {
		Guia guia = guiaController.findGuiaById(id);
		return guia;
	}
	public void confirmarAlteracao(Guia guia) {
		guiaController.updateById(guia);
	}
	
	public void criarGuia(Guia guia) {
		guiaController.create(guia);
	}
	
	public List<Guia> guiasExistentes() {
		return guiaController.findAll();
	}
	
}
