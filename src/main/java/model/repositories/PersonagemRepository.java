package model.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import model.entities.Personagem;

public class PersonagemRepository implements BasicCrud{
	
	EntityManager em = Persistence.createEntityManagerFactory("fg_site").createEntityManager();

	@Override
	public Object create(Object object) {
		Personagem personagemNovo = (Personagem) object;
		em.getTransaction().begin();
		em.persist(personagemNovo);
		em.getTransaction().commit();
		return findById(personagemNovo.getId()); //catch exception
	}

	@Override
	public Object findById(Long id) {
		try {
			Personagem personagemInBd = em.find(Personagem.class, id);
			return personagemInBd;
		} catch (Exception e) {
			
		}
		return null;
	}
	
	@Override
	public Object findByName(String name) {
		try {
			Personagem personagemInBd = em.find(Personagem.class, name);
			return personagemInBd;
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public Object updateById(Object object) {
		Personagem personagemUpdate = (Personagem) object;
		em.getTransaction().begin();
		em.merge(personagemUpdate);
		em.getTransaction().commit();
		return null;
	}

	@Override
	public void delete(Long id) {
		em.getTransaction().begin();
		Personagem personagem = (Personagem) findById(id);
		em.remove(personagem);
		em.getTransaction().commit();
		}
	
	public List<Personagem> findByGameId(Long id) {
		return em.createQuery("SELECT p FROM Personagem p WHERE p.jogo.id = :gameId", Personagem.class)
	             .setParameter("gameId", id)
	             .getResultList();
	}
	
	public List<Personagem> findAll(){
		return em.createQuery("SELECT p FROM Personagem p",Personagem.class).getResultList();
	}

}
	
