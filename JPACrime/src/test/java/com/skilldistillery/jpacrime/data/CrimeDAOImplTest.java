package com.skilldistillery.jpacrime.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.skilldistillery.jpacrime.entities.Crime;

class CrimeDAOImplTest {

	private static CrimeDAO dao;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		dao = new CrimeDAOImpl();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		dao = null;
	}

	@Test
	void test_create_update_delete() {
		Crime crime = new Crime("UNKNOWN", LocalDateTime.of(2024, 1, 1, 0, 0));
		
		Crime created = dao.create(crime);
		
		assertNotNull(created);
		assertTrue(created.getId() > 8);
		
		Crime updateCrime = new Crime("MURDER", LocalDateTime.of(2024, 1, 1, 0, 0));
		Crime updated = dao.update(created.getId(), updateCrime);
		
		assertNotNull(updated);
		assertEquals("MURDER", updated.getTypeOfCrime());
		
		boolean deleted = dao.destroy(created.getId());
		assertTrue(deleted);
	}

}
