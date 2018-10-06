package com.gk.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.gk.app.exception.MotorBikeNotFoundException;
import com.gk.app.service.MotorBikeService;
import com.gk.entity.MotorBike;

/**
 * 
 * @author Gangadhar Kasturi
 *  If you want to send some properties for some responses and some other properties for some other responses
 *  then dynamic filtering comes into picture.
 *  
 *
 */
@RestController
public class MotorBikeController {

	@Autowired
	public MotorBikeService motorBikeService;
	
	@GetMapping(value = "/getAllMotorBikesWithOutEngineNoChassisNo")
	public MappingJacksonValue getAllMotorBikesWithOutEngineNoChassisNo() {
		List<MotorBike> motorBikes= motorBikeService.findAll();
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("bikeId","model","manufacturer"); //define what do u want in response here
		FilterProvider filters = new SimpleFilterProvider().addFilter("MotorBikeFilter", filter );//define the filter here and mention this at your MotorBike.java class with @JsonFilter property
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(motorBikes);//inject the actual data here
		
		mappingJacksonValue.setFilters(filters);//filtering the data which is in mappingJacksonValue.,.i.e. filtering your actual data with ur filter
		return mappingJacksonValue; //always return the filtered data in the place of your actual data to reflect the filtering.

	}

	@GetMapping(value = "/getAllMotorBikesChassisNo")
	public MappingJacksonValue getAllMotorBikesChassisNo() {
		List<MotorBike> motorBikes= motorBikeService.findAll();
		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(motorBikes);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("chassisNo");
		FilterProvider filters = new SimpleFilterProvider().addFilter("MotorBikeFilter", filter ); //must be same name as specified above because both the filters belongs to same class MotorBike.java
		mappingJacksonValue.setFilters(filters );
		
		return mappingJacksonValue;
	}
	
	
	
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
