package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Destinations;

/**
 * Sterling Rhone - sprhone
 * 202102 CIS175 26740
 * Mar 15, 2021
 */
public class DestinationsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("adventuretravel");
	
	public void insertNewDestinations(Destinations des) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(des);
		em.getTransaction().commit();
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Destinations> getDestinations() {
		EntityManager em = emfactory.createEntityManager();
		List<Destinations> allDestinations = em.createQuery("SELECT des FROM Destinations des").getResultList();
		return allDestinations;
	}
}
