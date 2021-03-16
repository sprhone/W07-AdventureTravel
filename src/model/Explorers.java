package model;

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
@Table(name="explorers")
public class Explorers {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EXPLORER_ID")
	private int explorerId;
	@Column(name="EXPLORER_NAME")
	private String explorerName;
	@ManyToOne(cascade= {CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name="GEAR_ID")
	private Gear gear;
	@OneToMany(cascade= {CascadeType.MERGE, CascadeType.REFRESH}, fetch=FetchType.EAGER)
	@JoinTable(
			name="explorers_gear",
			joinColumns = {@JoinColumn(name="EXPLORER_ID", referencedColumnName = "EXPLORER_ID")},
			inverseJoinColumns = {@JoinColumn(name="GEAR_ID", referencedColumnName = "GEAR_ID", unique = true)}
			)
	private List<Gear> listOfGear;
	
	public Explorers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Explorers(int explorerId, String explorerName, Gear gear, List<Gear> listOfGear) {
		super();
		this.explorerId = explorerId;
		this.explorerName = explorerName;
		this.gear = gear;
		this.listOfGear = listOfGear;
	}

	public Explorers(String explorerName, Gear gear, List<Gear> listOfGear) {
		super();
		this.explorerName = explorerName;
		this.gear = gear;
		this.listOfGear = listOfGear;
	}

	public Explorers(String explorerName, Gear gear) {
		super();
		this.explorerName = explorerName;
		this.gear = gear;
	}

	public Explorers(String explorerName) {
		super();
		this.explorerName = explorerName;
	}

	public int getExplorerId() {
		return explorerId;
	}

	public void setExplorerId(int explorerId) {
		this.explorerId = explorerId;
	}

	public String getExplorerName() {
		return explorerName;
	}

	public void setExplorerName(String explorerName) {
		this.explorerName = explorerName;
	}

	public Gear getGear() {
		return gear;
	}

	public void setGear(Gear gear) {
		this.gear = gear;
	}

	public List<Gear> getListOfGear() {
		return listOfGear;
	}

	public void setListOfGear(List<Gear> listOfGear) {
		this.listOfGear = listOfGear;
	}

	@Override
	public String toString() {
		return "Explorers [explorerId=" + explorerId + ", explorerName=" + explorerName + ", gear=" + gear
				+ ", listOfGear=" + listOfGear + "]";
	}
}
