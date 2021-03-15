package model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Sterling Rhone - sprhone
 * 202102 CIS175 26740
 * Mar 11, 2021
 */


@Entity
@Table(name="destinations")
public class Destinations {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DESTINATION_ID")
	private int tripId;
	@Column(name="DESTINATION_NAME")
	private String destinationName;
	@Column(name="TRIP_DATE")
	private LocalDate tripDate;
	private List<Explorers> listOfExplorers;
	
	public Destinations() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Destinations(int tripId, String destinationName, LocalDate tripDate, List<Explorers> listOfExplorers) {
		super();
		this.tripId = tripId;
		this.destinationName = destinationName;
		this.tripDate = tripDate;
		this.listOfExplorers = listOfExplorers;
	}

	public Destinations(String destinationName, LocalDate tripDate, List<Explorers> listOfExplorers) {
		super();
		this.destinationName = destinationName;
		this.tripDate = tripDate;
		this.listOfExplorers = listOfExplorers;
	}

	public Destinations(String destinationName, LocalDate tripDate) {
		super();
		this.destinationName = destinationName;
		this.tripDate = tripDate;
	}

	public int getTripId() {
		return tripId;
	}

	public void setTripId(int tripId) {
		this.tripId = tripId;
	}

	public String getDestinationName() {
		return destinationName;
	}

	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}

	public LocalDate getTripDate() {
		return tripDate;
	}

	public void setTripDate(LocalDate tripDate) {
		this.tripDate = tripDate;
	}

	public List<Explorers> getListOfExplorers() {
		return listOfExplorers;
	}

	public void setListOfExplorers(List<Explorers> listOfExplorers) {
		this.listOfExplorers = listOfExplorers;
	}

	@Override
	public String toString() {
		return "Destinations [tripId=" + tripId + ", destinationName=" + destinationName + ", listOfExplorers="
				+ listOfExplorers + "]";
	}
	
	
}
