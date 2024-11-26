package com.skilldistillery.jpacrime.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

class CrimeTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	
	// entity under test
	private Crime crime;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("Crime");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		crime = em.find(Crime.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		crime = null;
	}

	@Test
	void test_Customer_basic_mapping() {
		assertNotNull(crime);
		assertEquals(1, crime.getId());
	}

}
