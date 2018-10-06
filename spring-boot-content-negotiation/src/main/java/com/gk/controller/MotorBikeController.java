package com.gk.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gk.app.exception.MotorBikeNotFoundException;
import com.gk.app.service.MotorBikeService;
import com.gk.entity.MotorBike;

/**
 * 
 * @author Gangadhar Kasturi
 * 
 * added jackson-dataformat-xml dependency in pom.
 * so when you make a request from postman,add accept : application/xml and content-type: application/xml in headers,
 * so that it will give xml as response and accepts xml as requests, 
 * if u need json replace tha like application/json.
 * i.e. if u need xml use like application/xml.
 * This is called as content negotiation in spring boot.
 * THis is due to the jackson jars in the project.
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
	public ResponseEntity<MotorBike> saveMotorBike(@Valid @RequestBody final MotorBike motorBike) {//@valid is to check for the request validations. i.e. to check if the data is coming properly or not in request.
		MotorBike savedMotorBike = motorBikeService.save(motorBike);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedMotorBike.getBikeId()).toUri();
		return ResponseEntity.created(location).build();
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

	@DeleteMapping(value = "/deleteMotorBikeById/{id}")
	public String deleteMotorBikeById(@PathVariable int id) {
		if(motorBikeService.deleteMotorBikeById(id)) 
		{
			return "MotorBike with id"+id+"is deleted succesfully";
		}
		throw new MotorBikeNotFoundException("MotorBike with id:"+id+"doesnot exist");

	}

}
