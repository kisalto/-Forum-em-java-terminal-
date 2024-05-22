package model.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import model.entities.Eventos;

public class EventosRepository implements BasicCrud{
	
	EntityManager em = Persistence.createEntityManagerFactory("fg_site").createEntityManager();

	@Override
	public Object create(Object object) {
		Eventos eventosNovo = (Eventos) object;
		em.getTransaction().begin();
		em.persist(eventosNovo);
		em.getTransaction().commit();
		return findById(eventosNovo.getId()); //catch exception
	}

	@Override
	public Object findById(Long id) {
		try {
			Eventos eventosInBd = em.find(Eventos.class, id);
			return eventosInBd;
		} catch (Exception e) {
			
		}
		return null;
	}
	
	@Override
	public Object findByName(String name) {
		try {
			Eventos eventosInBd = em.find(Eventos.class, name);
			return eventosInBd;
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public Object updateById(Object object) {
		Eventos eventosUpdate = (Eventos) object;
		em.getTransaction().begin();
		em.merge(eventosUpdate);
		em.getTransaction().commit();
		return null;
	}

	@Override
	public void delete(Long id) {
		em.getTransaction().begin();
		Eventos eventos = (Eventos) findById(id);
		em.remove(eventos);
		em.getTransaction().commit();
		}
	
	public List<Eventos> findAll(){
		return em.createQuery("SELECT e FROM Eventos e", Eventos.class).getResultList();
	}

	public List<Eventos> findByUser(Long id) {
	    return em.createQuery("SELECT e FROM Eventos e WHERE e.usuario.id = :userId", Eventos.class)
	             .setParameter("userId", id)
	             .getResultList();
	}
}
	
