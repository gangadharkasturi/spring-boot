package com.gk.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.gk.dto.Course;
import com.gk.dto.Student;

/**
 * 
 * @author Gangadhar K
 *
 */
@Component
public class StudentService {
	public static List<Student> students = new ArrayList<>();
	static {
		Course course1 = new Course("Course1", "Spring", "10Steps", Arrays.asList("Step1", "Step2", "Step3"));
		Course course2 = new Course("Course1", "Struts", "10Steps", Arrays.asList("Step2", "Step3", "Step4"));
		Course course3 = new Course("Course1", "Maven", "10Steps", Arrays.asList("Step1", "Step2", "Step3"));
		Course course4 = new Course("Course1", "Git", "10Steps", Arrays.asList("Step1", "Step2", "Step3"));
		Student ranga = new Student("Student1", "Ranga Karanam", "Hiker, Programmer and Architect",
				new ArrayList<>(Arrays.asList(course1, course2, course3, course4)));

		students.add(ranga);
	}

	public Student retriveStudent(String studentId) {
		for (Student s : students) {
			if (s.getId().equals(studentId)) {
				return s;
			}
		}
		return null;
	}

	public List<Course> retriveCourses(String studentId) {
	Student student = retriveStudent(studentId);
	if (student == null) {
		return null;
	}

	return student.getCourses();
	}
}
