package com.gk.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Person {

	@Id @GeneratedValue private int personId;
	private String personName;
	@OneToMany(mappedBy="person")
	private List<MotorBike> motorBikes;
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public List<MotorBike> getMotorBikes() {
		return motorBikes;
	}
	public void setMotorBikes(List<MotorBike> motorBikes) {
		this.motorBikes = motorBikes;
	}
}
