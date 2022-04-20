package it.uniroma3.siw.main;

import javax.persistence.*;

public class CorsiMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("corsi-unit");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//em.persist();
		tx.commit();

		em.close();
		emf.close();
	}
}