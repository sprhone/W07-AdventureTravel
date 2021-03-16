package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

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
	

	public List<Explorers> showAllExplorers() {
		EntityManager em = emfactory.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Explorers> allExplorers = em.createQuery("SELECT exp FROM Explorers exp").getResultList();
		return allExplorers;
	}
	
	public Explorers searchForExplorerById(Integer idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Explorers found = em.find(Explorers.class, idToEdit);
		em.close();
		return found;
	}
	
	public List<Explorers> searchForExplorerByName(String explorerName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Explorers> typedQuery = em.createQuery("SELECT exp FROM Explorers exp WHERE exp.explorerName = :selectedexplorerName", Explorers.class);
		typedQuery.setParameter("selectedexplorerName", explorerName);
		
		List<Explorers> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public void deleteExplorer(Explorers toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Explorers> typedQuery = em.createQuery("SELECT exp FROM Explorers exp WHERE exp.explorerName = :selectedexplorerName", Explorers.class);
		
		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedexplorerName", toDelete.getExplorerName());
		
		//we only want one result
		typedQuery.setMaxResults(1);
		
		//get the result and save it into a new list item
		Explorers result = typedQuery.getSingleResult();
		
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public void updateExplorer(Explorers toEdit) {
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
