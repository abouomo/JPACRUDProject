package com.skilldistillery.bootcrime.data;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skilldistillery.jpacrime.entities.Crime;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class CrimeDAOImpl implements CrimeDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Crime create(Crime crime) {

		// write the crime to the database
		em.persist(crime);
		// update the "local" crime object
		em.flush();

		// return the Crime object
		return crime;
	}

	@Override
	public Crime update(int id, Crime crime) {

		Crime managedCrime = em.find(Crime.class, id);

		managedCrime.setTypeOfCrime(crime.getTypeOfCrime());
		managedCrime.setDateOfCrime(crime.getDateOfCrime());
		managedCrime.setDescription(crime.getDescription());
		managedCrime.setLocationOfCrime(crime.getLocationOfCrime());
		managedCrime.setInvestigator(crime.getInvestigator());

		return managedCrime;
	}

	@Override
	public boolean destroy(int id) {

		boolean wasDeleted = false;

		Crime crime = em.find(Crime.class, id);
		if (crime != null) {

			em.remove(crime);
			wasDeleted = true;

		}

		wasDeleted = !em.contains(crime);

		return wasDeleted;
	}

	@Override
	public Crime findById(int crimeId) {

		Crime crime = em.find(Crime.class, crimeId);

		return crime;
	}

	@Override
	public List<Crime> findAll() {
		String jpql = "SELECT crime FROM Crime crime";
		List<Crime> crimes  = em.createQuery(jpql, Crime.class).getResultList();
		return crimes;
	}

}
