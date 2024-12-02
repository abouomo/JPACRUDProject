package com.skilldistillery.jpacrime.client;

import com.skilldistillery.jpacrime.entities.Crime;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CrimeClient {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Crime");
		EntityManager em = emf.createEntityManager();

		Crime crime = em.find(Crime.class, 1);
		System.out.println(crime);
		// No memory leaks...
		em.close();
		emf.close();
	}

}
