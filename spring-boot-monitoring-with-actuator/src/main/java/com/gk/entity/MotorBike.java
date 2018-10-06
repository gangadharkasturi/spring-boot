package com.gk.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

	@Size(max=5,min=2,message="chassis num should be in between 2 to 5 chars") //validation for size of min , max values in request.
	private String chassisNo;

	@NotNull(message="manufacturer must not be null") //javax validation to not allow null values in request.
			//this is not related database.. purely for validations.
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
