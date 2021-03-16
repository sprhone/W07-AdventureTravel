package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

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
	
	public List<Destinations> showAllDestinations() {
		EntityManager em = emfactory.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Destinations> allDestinations = em.createQuery("SELECT des FROM Destinations des").getResultList();
		return allDestinations;
	}
	
	public Destinations searchForDestinationById(Integer idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Destinations found = em.find(Destinations.class, idToEdit);
		em.close();
		return found;
	}
	
	public List<Destinations> searchForDestinationByName(String destinationName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Destinations> typedQuery = em.createQuery("SELECT des FROM Destinations des WHERE des.destinationName = :selecteddestinationName", Destinations.class);
		typedQuery.setParameter("selecteddestinationName", destinationName);
		
		List<Destinations> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public void deleteDestination(Destinations toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Destinations> typedQuery = em.createQuery("SELECT des FROM Destinations des WHERE des.destinationName = :selecteddestinationName", Destinations.class);
		
		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selecteddestinationName", toDelete.getDestinationName());
		
		//we only want one result
		typedQuery.setMaxResults(1);
		
		//get the result and save it into a new list item
		Destinations result = typedQuery.getSingleResult();
		
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public void updateDestination(Destinations toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();	
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();		
	}
	
	public void cleanUp() {
		emfactory.close();
	}
}
