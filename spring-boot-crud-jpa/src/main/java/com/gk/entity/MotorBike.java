package com.gk.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * @author Gangadhar, Kasturi
 *
 */
@Entity

public class MotorBike {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bikeId;

	private String chassisNo;

	private String manufacturer;

	private String engineNo;

	private String model;

	public String getChassisNo() {
		return chassisNo;
	}

	public void setChassisNo(String chassisNo) {
		this.chassisNo = chassisNo;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getEngineNo() {
		return engineNo;
	}

	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}

	public int getBikeId() {
		return bikeId;
	}

	public void setBikeId(int bikeId) {
		this.bikeId = bikeId;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "MotorBike [chassisNo=" + chassisNo + ", manufacturer=" + manufacturer + ", engineNo=" + engineNo
				+ ", bikeId=" + bikeId + ", model=" + model + "]";
	}
}
