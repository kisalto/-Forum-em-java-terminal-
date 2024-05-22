package model.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.entities.Usuario;

public class UsuarioRepository implements BasicCrud{
	
	EntityManager em = Persistence.createEntityManagerFactory("fg_site").createEntityManager();
	
	@Override
	public Object create(Object object) {
		Usuario usuarioNovo = (Usuario) object;
		em.getTransaction().begin();
		em.persist(usuarioNovo);
		em.getTransaction().commit();
		return findById(usuarioNovo.getId());
	}
	
	@Override
	public Object findById(Long id) {
		try {
			Usuario usuarioInBd = em.find(Usuario.class, id);
			return usuarioInBd;
		} catch(Exception e) {
			return null;
		}
	}
	
	@Override
	public Object findByName(String name) {
		try {
			TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.nickname = :name", Usuario.class);
			query.setParameter("name", name);
			return query.getSingleResult();
		} catch (Exception e) {
			return null;			
		}
	}
	
	@Override
	public Object updateById(Object object) {
		Usuario usuarioUpdate = (Usuario) object;
		em.getTransaction().begin();
		em.remove(usuarioUpdate);
		em.getTransaction().commit();
		return null;
	}
	
	@Override
	public void delete(Long id) {
		em.getTransaction().begin();
		Usuario usuario = (Usuario) findById(id);
		em.remove(usuario);
		em.getTransaction().commit();
	}
	
	public List<Usuario> findAll() {
		return em.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
	}
}
