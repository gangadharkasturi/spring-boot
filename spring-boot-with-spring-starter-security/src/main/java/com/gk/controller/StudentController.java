package com.gk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.gk.dto.Course;
import com.gk.service.StudentService;

/**
 * 
 * @author Gangadhar
 *
 */
@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;

	@GetMapping(value = "/students/{studentId}/courses",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Course> retriveCoursesForStudent(@PathVariable final String studentId) {
		return studentService.retriveCourses(studentId);
	}

}
