package com.udemy;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestEndPointsGet {

	//http://localhost:8080/course?name=kiran&chapterCount=5 use this to Hit
	//http://localhost:8080/course
	//http://localhost:8080/course?name=kiran
	
	@RequestMapping("/course")
	public Course getEndPoint(@RequestParam (value="name",defaultValue="Spring Boot Course",required=false) String name,
			@RequestParam (value="chapterCount",defaultValue="2",required=false) int chapterCount
			) {
		return new Course(name,chapterCount);
	}
	@RequestMapping(method=RequestMethod.POST,value="/register/course")
	public String postEndPoint(@RequestBody Course course) {
		return " Your Course"+course.getName()+" With "+course.getChapterCount()+" chapters are saved.!";
	}
}
