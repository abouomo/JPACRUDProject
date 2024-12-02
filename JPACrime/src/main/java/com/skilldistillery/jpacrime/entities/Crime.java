package com.skilldistillery.jpacrime.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Crime {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="type_of")
	private String typeOfCrime;
	@Column(name="date_of")
	private LocalDateTime dateOfCrime;
	private String description;
	@Column(name="location_of")
	private String locationOfCrime;
	private String investigator;
	
	public Crime() {
		
	}
	

	public Crime(String typeOfCrime, LocalDateTime dateOfCrime) {
		super();
		this.typeOfCrime = typeOfCrime;
		this.dateOfCrime = dateOfCrime;
	}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

	public String getTypeOfCrime() {
		return typeOfCrime;
	}

	public void setTypeOfCrime(String typeOfCrime) {
		this.typeOfCrime = typeOfCrime;
	}

	public LocalDateTime getDateOfCrime() {
		return dateOfCrime;
	}

	public void setDateOfCrime(LocalDateTime dateOfCrime) {
		this.dateOfCrime = dateOfCrime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocationOfCrime() {
		return locationOfCrime;
	}

	public void setLocationOfCrime(String locationOfCrime) {
		this.locationOfCrime = locationOfCrime;
	}

	public String getInvestigator() {
		return investigator;
	}

	public void setInvestigator(String investigator) {
		this.investigator = investigator;
	}

	@Override
	public String toString() {
		return "Crime [id=" + id + ", typeOfCrime=" + typeOfCrime + ", dateOfCrime=" + dateOfCrime + ", description="
				+ description + ", locationOfCrime=" + locationOfCrime + ", investigator=" + investigator + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Crime other = (Crime) obj;
		return id == other.id;
	}
	
	

}
