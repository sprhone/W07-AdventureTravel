package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Explorers;

/**
 * Sterling Rhone - sprhone
 * 202102 CIS175 26740
 * Mar 15, 2021
 */
public class ExplorerHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("adventuretravel");
	
	public void insertExplorers(Explorers exp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(exp);
		em.getTransaction().commit();
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Explorers> showAllExplorers() {
		EntityManager em = emfactory.createEntityManager();
		List<Explorers> allExplorers = em.createQuery("SELECT exp FROM Explorers exp").getResultList();
		return allExplorers;
	}
}
