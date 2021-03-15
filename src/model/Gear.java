package model;

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
@Table(name="gear")
public class Gear {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="GEAR_ID")
	private int gearId;
	@Column(name="GEAR_NAME")
	private String gearName;
	
	public Gear() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Gear(int gearId, String gearName) {
		super();
		this.gearId = gearId;
		this.gearName = gearName;
	}

	public int getGearId() {
		return gearId;
	}

	public void setGearId(int gearId) {
		this.gearId = gearId;
	}

	public String getGearName() {
		return gearName;
	}

	public void setGearName(String gearName) {
		this.gearName = gearName;
	}

	@Override
	public String toString() {
		return "Gear [gearId=" + gearId + ", gearName=" + gearName + "]";
	}
	
	
}
