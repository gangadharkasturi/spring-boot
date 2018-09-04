package com.gk.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gk.dao.MotorBikeRepo;
import com.gk.entity.MotorBike;

/**
 * 
 * @author Gangadhar Kasturi
 *
 */

@Repository
public class MotorBikeService {

	@Autowired
	public MotorBikeRepo motorBikeRepo;

	public Optional<MotorBike> getMotorBikeById(int bikeId) {
		Optional<MotorBike> bike = motorBikeRepo.findById(bikeId);
		return bike;

	}

	public boolean save(MotorBike motorBike) {
		if (motorBikeRepo.save(motorBike) != null)
			return true;
		return false;
	}

	public List<MotorBike> findAll() {
		return motorBikeRepo.findAll();
	}

	public void deleteAll() {
		motorBikeRepo.deleteAll();
	}

	public void deleteMotorBikeById(int id) {
		motorBikeRepo.deleteById(id);
	}
}