package model.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import model.entities.UltimoEvento;

public class UltimoEventoRepository implements BasicCrud{
	
	EntityManager em = Persistence.createEntityManagerFactory("fg_site").createEntityManager();
	
	@Override
	public Object create(Object object) {
		UltimoEvento ultimoEventoNovo = (UltimoEvento) object;
		em.getTransaction().begin();
		em.persist(ultimoEventoNovo);
		em.getTransaction().commit();
		return findById(ultimoEventoNovo.getId());
	}
	
	@Override
	public Object findById(Long id) {
		try {
			UltimoEvento ultimoEventoInBd = em.find(UltimoEvento.class, id);
			return ultimoEventoInBd;
		} catch(Exception e) {
			
		}
		return null;
	}
	
	@Override
	public Object findByName(String name) {
		try {
			UltimoEvento ultimoEventoInBd = em.find(UltimoEvento.class, name);
			return ultimoEventoInBd;
		} catch(Exception e) {
			
		}
		return null;
	}
	@Override
	public Object updateById(Object object) {
		UltimoEvento ultimoEventoUpdate = (UltimoEvento) object;
		em.getTransaction().begin();
		em.remove(ultimoEventoUpdate);
		em.getTransaction().commit();
		return null;
	}
	
	@Override
	public void delete(Long id) {
		em.getTransaction().begin();
		UltimoEvento ultimoEvento = (UltimoEvento) findById(id);
		em.remove(ultimoEvento);
		em.getTransaction().commit();
	}
	
	public List<UltimoEvento> findAll() {
		return em.createQuery("SELECT ue FROM Ultimo_evento ue WHERE ue.id > 2", UltimoEvento.class).getResultList();
	}
}
