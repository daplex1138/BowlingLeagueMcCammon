package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Team;



public class TeamHelper {
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BowlingLeagueMcCammon");
	
	public void insertItem(Team toAdd) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Team> getAllTeams() {
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Team> allResults = em.createQuery("SELECT team FROM Team team ORDER BY team.teamName", Team.class);
		List<Team> allItems = allResults.getResultList();
		em.close();
		return allItems;
	}

	public Team searchForTeamById(int searchId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Team foundItem = em.find(Team.class, searchId);
		em.close();
		return foundItem;
	}
}
