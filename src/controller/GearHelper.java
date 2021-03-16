package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Gear;

/**
 * Sterling Rhone - sprhone
 * 202102 CIS175 26740
 * Mar 15, 2021
 */
public class GearHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("adventuretravel");
	
	public void insertGear(Gear g) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(g);
		em.getTransaction().commit();
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Gear> showAllGear() {
		EntityManager em = emfactory.createEntityManager();
		List<Gear> allGear = em.createQuery("SELECT g FROM Gear g").getResultList();
		return allGear;
	}

	public Gear searchForGearById(Integer idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Gear found = em.find(Gear.class, idToEdit);
		em.close();
		return found;
	}
	
	public List<Gear> searchForGearByName(String gearName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Gear> typedQuery = em.createQuery("SELECT g FROM Gear g WHERE g.gearName = :selectedgearName", Gear.class);
		typedQuery.setParameter("selectedGear", gearName);
		
		List<Gear> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public void deleteGear(Gear toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Gear> typedQuery = em.createQuery("SELECT g FROM Gear g WHERE g.gearName = :selectedgearName", Gear.class);
		
		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedgearName", toDelete.getGearName());
		
		//we only want one result
		typedQuery.setMaxResults(1);
		
		//get the result and save it into a new list item
		Gear result = typedQuery.getSingleResult();
		
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public void updateGear(Gear toEdit) {
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
