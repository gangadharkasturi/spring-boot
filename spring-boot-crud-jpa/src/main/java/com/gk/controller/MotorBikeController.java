package com.gk.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gk.app.service.MotorBikeService;
import com.gk.entity.MotorBike;

/**
 * 
 * @author Gangadhar Kasturi
 *
 */
@RestController
public class MotorBikeController {

	@Autowired
	public MotorBikeService motorBikeService;

	@RequestMapping("/getMotorBikeById/{id}")
	public Optional<MotorBike> getMotorBikeById(@PathVariable int id) {
		return motorBikeService.getMotorBikeById(id);
	}

	@PostMapping(value = "/saveMotorBike")
	public String saveMotorBike(@RequestBody final MotorBike motorBike) {
		boolean status = motorBikeService.save(motorBike);
		if (status == true) {
			return "Motorbike with id: " + motorBike.getBikeId() + " has been saved.!";
		} else {
			return "Not possible to save this MotorBike with id : " + motorBike.getBikeId();
		}
	}

	@GetMapping(value = "/getAllMotorBikes")
	public List<MotorBike> getAllMotorBikes() {
		return motorBikeService.findAll();

	}

	@PostMapping(value = "/deleteAllMotorBikes")
	public String deleteAllMotorBikes() {
		motorBikeService.deleteAll();
		return "All the motorbikes deleted.!";

	}

	@PostMapping(value = "/deleteMotorBikeById/{id}")
	public String deleteMotorBikeById(@PathVariable int id) {
		motorBikeService.deleteMotorBikeById(id);
		return "Motorbike with id: " + id + " has been deleted.!";

	}

}
