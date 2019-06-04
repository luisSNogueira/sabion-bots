package br.com.sabion.DAO;

import javax.persistence.EntityManager;

import br.com.sabion.model.DTO;

public class GenericDAO<T extends DTO> {
	
	public T findById(Class<T> model, Long id, EntityManager em) {
		return em.find(model, id);
	}
	
	public void saveOrUpdate(T model, EntityManager em) {
		try{
			em.getTransaction().begin();
			if(model.getId() == null) {
				em.persist(model);
			} else {
				em.merge(model);
			}
			em.getTransaction().commit();
		} catch(Exception e) {
			em.getTransaction().rollback();
		}
	}
	
	public void remove(Class<T> model, Long id, EntityManager em) {
		T t = this.findById(model, id, em);
		try{
			em.getTransaction().begin();
			em.remove(t);
			em.getTransaction().commit();
		} catch(Exception e) {
			em.getTransaction().rollback();
		}
	}

}
