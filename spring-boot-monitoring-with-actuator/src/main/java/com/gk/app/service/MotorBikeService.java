package com.gk.app.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gk.app.exception.MotorBikeException;
import com.gk.app.exception.MotorBikeNotFoundException;
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
		if (!bike.isPresent() )
			throw new MotorBikeNotFoundException("MotorBike" + bikeId + " Not Found on:" + new Date());
		return bike;

	}

	public MotorBike save(MotorBike motorBike) {
		if(motorBikeRepo.save(motorBike) != null)
			return motorBike;
		return null;
	}
	public List<MotorBike> findAll() {
		return motorBikeRepo.findAll();
	}

	public void deleteAll() {
		motorBikeRepo.deleteAll();
	}

	public boolean deleteMotorBikeById(int id) {
		motorBikeRepo.deleteById(id);
		return true;
	}
}