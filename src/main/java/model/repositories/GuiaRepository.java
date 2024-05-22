package model.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import model.entities.Guia;

public class GuiaRepository implements BasicCrud{
	
	EntityManager em = Persistence.createEntityManagerFactory("fg_site").createEntityManager();

	@Override
	public Object create(Object object) {
		Guia guiaNovo = (Guia) object;
		em.getTransaction().begin();
		em.persist(guiaNovo);
		em.getTransaction().commit();
		return findById(guiaNovo.getId()); //catch exception
	}

	@Override
	public Object findById(Long id) {
		try {
			Guia guiaInBd = em.find(Guia.class, id);
			return guiaInBd;
		} catch (Exception e) {
			
		}
		return null;
	}
	
	@Override
	public Object findByName(String name) {
		try {
			Guia guiaInBd = em.find(Guia.class, name);
			return guiaInBd;
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public Object updateById(Object object) {
		Guia guiaUpdate = (Guia) object;
		em.getTransaction().begin();
		em.merge(guiaUpdate);
		em.getTransaction().commit();
		return null;
	}

	@Override
	public void delete(Long id) {
		em.getTransaction().begin();
		Guia guia = (Guia) findById(id);
		em.remove(guia);
		em.getTransaction().commit();
	}
	
	public List<Guia> findAll(){
		return em.createQuery("SELECT g FROM Guia g", Guia.class).getResultList();
	}

	public List<Guia> findByUser(Long id) {
	    return em.createQuery("SELECT g FROM Guia g WHERE g.usuario.id = :userId", Guia.class)
	             .setParameter("userId", id)
	             .getResultList();
	}
	
}
	
