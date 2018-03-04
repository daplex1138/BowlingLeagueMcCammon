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
	public void deleteItem(Team toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Team> typedQuery = em.createQuery("select li from Team li where li.teamName = :selectedTeam and li.teamType = :selectedTeamType", Team.class);
		typedQuery.setParameter("selectedTeam", toDelete.getTeamName());
		typedQuery.setParameter("selectedTeamType", toDelete.getTeamType());
		typedQuery.setMaxResults(1);
		Team result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		
	}
}
