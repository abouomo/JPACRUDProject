package com.skilldistillery.jpacrime.data;

import com.skilldistillery.jpacrime.entities.Crime;

public interface CrimeDAO {
	
	Crime findById(int crimeId);
	Crime create(Crime crime);
	Crime update(int id, Crime crime);
	boolean destroy(int id);

}
