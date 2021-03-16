package model;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="EXPLORER_ID")
	private Explorers explorers;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
		@JoinTable(
				name="destinations",
				joinColumns = {
						@JoinColumn(name="DESTINATION_ID", referencedColumnName = "DESTINATION_ID")},
				inverseJoinColumns = {
						@JoinColumn(name="EXPLORER_ID", referencedColumnName = "EXPLORER_ID", unique = true)
				})	
	private List<Explorers> listOfExplorers;
	
	public Destinations() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Destinations(int tripId, String destinationName, LocalDate tripDate, Explorers explorers,
			List<Explorers> listOfExplorers) {
		super();
		this.tripId = tripId;
		this.destinationName = destinationName;
		this.tripDate = tripDate;
		this.explorers = explorers;
		this.listOfExplorers = listOfExplorers;
	}

	public Destinations(String destinationName, LocalDate tripDate, Explorers explorers,
			List<Explorers> listOfExplorers) {
		super();
		this.destinationName = destinationName;
		this.tripDate = tripDate;
		this.explorers = explorers;
		this.listOfExplorers = listOfExplorers;
	}

	public Destinations(String destinationName, LocalDate tripDate, Explorers explorers) {
		super();
		this.destinationName = destinationName;
		this.tripDate = tripDate;
		this.explorers = explorers;
	}

	public int getTripId() {
		return tripId;
	}

	public void setTripId(int tripId) {
		this.tripId = tripId;
	}

	public Explorers getExplorers() {
		return explorers;
	}

	public void setExplorers(Explorers explorers) {
		this.explorers = explorers;
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
		return "Destinations [tripId=" + tripId + ", destinationName=" + destinationName + ", tripDate=" + tripDate
				+ ", explorers=" + explorers + ", listOfExplorers=" + listOfExplorers + "]";
	}
}
