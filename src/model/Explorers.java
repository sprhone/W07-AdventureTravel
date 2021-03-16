package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private int explorerID;
	@Column(name="EXPLORER_NAME")
	private String explorerName;
	@OneToMany(
			cascade=CascadeType.ALL, fetch=FetchType.EAGER, orphanRemoval = true
			)
	private List<Gear> listOfGear;
	
	public Explorers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Explorers(int explorerID, String explorerName, List<Gear> listOfGear) {
		super();
		this.explorerID = explorerID;
		this.explorerName = explorerName;
		this.listOfGear = listOfGear;
	}

	public Explorers(String explorerName, List<Gear> listOfGear) {
		super();
		this.explorerName = explorerName;
		this.listOfGear = listOfGear;
	}

	public Explorers(String explorerName) {
		super();
		this.explorerName = explorerName;
	}

	public int getExplorerID() {
		return explorerID;
	}

	public void setExplorerID(int explorerID) {
		this.explorerID = explorerID;
	}

	public String getExplorerName() {
		return explorerName;
	}

	public void setExplorerName(String explorerName) {
		this.explorerName = explorerName;
	}

	public List<Gear> getListOfGear() {
		return listOfGear;
	}

	public void setListOfGear(List<Gear> listOfGear) {
		this.listOfGear = listOfGear;
	}

	@Override
	public String toString() {
		return "Explorers [explorerID=" + explorerID + ", explorerName=" + explorerName + ", listOfGear=" + listOfGear
				+ "]";
	}	
}
