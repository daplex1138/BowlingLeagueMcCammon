package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.GalleryArtPiece;

public class GalleryArtHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ArtGalleryBrommer");

	public void insertItem(GalleryArtPiece toAdd) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}

	public void cleanUp() {
		emfactory.close();
	}

	public List<GalleryArtPiece> showAllItems() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<GalleryArtPiece> allResults = em.createQuery("select li from GalleryArtPiece li", GalleryArtPiece.class);
		List <GalleryArtPiece> allArt = allResults.getResultList();
		em.close();
		return allArt;
	}
	
	public void deleteItem(GalleryArtPiece toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		GalleryArtPiece toRemove = em.find(GalleryArtPiece.class, toDelete.getId());
		em.remove(toRemove);
		em.getTransaction().commit();
		em.close();
	}

	public GalleryArtPiece searchForItemById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		GalleryArtPiece foundItem = em.find(GalleryArtPiece.class, idToEdit);
		em.close();
		return foundItem;
	}
	
	public void updateItem(GalleryArtPiece toEdit) {
		// TODO Auto-generated method stub
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
			
	}
}
