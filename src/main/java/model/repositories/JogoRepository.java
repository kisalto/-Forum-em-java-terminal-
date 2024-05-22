package model.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import model.entities.Jogo;

public class JogoRepository implements BasicCrud{
	
	EntityManager em = Persistence.createEntityManagerFactory("fg_site").createEntityManager();
	
	@Override
	public Object create(Object object) {
		Jogo jogoNovo = (Jogo) object;
		em.getTransaction().begin();
		em.persist(jogoNovo);
		em.getTransaction().commit();
		return findById(jogoNovo.getId());
	}
	
	@Override
	public Object findById(Long id) {
		try {
			Jogo jogoInBd = em.find(Jogo.class, id);
			return jogoInBd;
		} catch(Exception e) {
			
		}
		return null;
	}
	
	@Override
	public Object findByName(String name) {
		try {
			Jogo jogoInBd = em.find(Jogo.class, name);
			return jogoInBd;
		} catch(Exception e) {
			
		}
		return null;
	}
	
	@Override
	public Object updateById(Object object) {
		Jogo jogoUpdate = (Jogo) object;
		em.getTransaction().begin();
		em.remove(jogoUpdate);
		em.getTransaction().commit();
		return null;
	}
	
	@Override
	public void delete(Long id) {
		em.getTransaction().begin();
		Jogo jogo = (Jogo) findById(id);
		em.remove(jogo);
		em.getTransaction().commit();
	}
	
	public List<Jogo> findAll() {
		return em.createQuery("SELECT j FROM Jogo j", Jogo.class).getResultList();
	}
}
