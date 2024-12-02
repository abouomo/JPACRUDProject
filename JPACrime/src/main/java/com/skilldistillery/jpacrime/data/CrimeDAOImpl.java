package com.skilldistillery.jpacrime.data;

import com.skilldistillery.jpacrime.entities.Crime;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CrimeDAOImpl implements CrimeDAO {

	

	@Override
	public Crime create(Crime crime) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Crime");
		EntityManager em = emf.createEntityManager();

		// start the transaction
		em.getTransaction().begin();
		// write the crime to the database
		em.persist(crime);
		// update the "local" crime object
		em.flush();
		// commit the changes (actually perform the operation)
		em.getTransaction().commit();

		em.close();
		emf.close();
		// return the Crime object
		return crime;
	}

	@Override
	public Crime update(int id, Crime crime) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Crime");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		Crime managedCrime = em.find(Crime.class, id);

		managedCrime.setTypeOfCrime(crime.getTypeOfCrime());
		managedCrime.setDateOfCrime(crime.getDateOfCrime());
		managedCrime.setDescription(crime.getDescription());
		managedCrime.setLocationOfCrime(crime.getLocationOfCrime());
		managedCrime.setInvestigator(crime.getInvestigator());
		em.getTransaction().commit();

		em.close();
		emf.close();
		return managedCrime;
	}

	@Override
	public boolean destroy(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Crime");
		boolean wasDeleted = false;
		EntityManager em = emf.createEntityManager();
		
		Crime crime = em.find(Crime.class, id);
		if(crime != null) {
			em.getTransaction().begin();
			
			em.remove(crime);
			wasDeleted = true;
			em.getTransaction().commit();
		}

		wasDeleted = !em.contains(crime);
		
		em.close();
		emf.close();
		return wasDeleted;
	}

}
