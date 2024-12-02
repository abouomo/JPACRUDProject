package com.skilldistillery.jpacrime.client;

import java.time.LocalDateTime;

import com.skilldistillery.jpacrime.data.CrimeDAO;
import com.skilldistillery.jpacrime.data.CrimeDAOImpl;
import com.skilldistillery.jpacrime.entities.Crime;

public class CrimeDAOClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Create");
		CrimeDAO dao = new CrimeDAOImpl();
		Crime crimeEvent = new Crime("murder", LocalDateTime.of(2020, 1, 1, 0, 0));
		// Create
		Crime managedCrime = dao.create(crimeEvent);
		System.out.println(managedCrime);

		//Update date
		System.out.println("\nUpdate");
		Crime updateCrimeEvent = new Crime("murder", LocalDateTime.of(2020, 2, 1, 0, 0));
		Crime updatedCrime = dao.update(managedCrime.getId(), updateCrimeEvent);
		System.out.println(updatedCrime);
		
		// Delete
		System.out.println("\nDelete");
		Crime newCrimeEvent = new Crime("ROBBERY", LocalDateTime.of(2024, 10, 10, 0, 0));
		Crime newManagedCrime = dao.create(newCrimeEvent);
		System.out.println(newManagedCrime);
		dao.destroy(newManagedCrime.getId());
		System.out.println(newManagedCrime); 

	}

}
