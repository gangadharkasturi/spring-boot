package com.udemy;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	//mvn spring-boot:run -Dspring.profiles.active=qa is used to build on some specific profile,where qa is name of application-.property file name
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
	
	@Value("${default.course.name}")
	private String defaultCourse;
	@Value("${default.course.chapterCount}")
	private int defaultChapterCount;
	
	//http://localhost:9090/courseDefaults?name=hi&chapterCount=20
	/*
	 * output:{
    "name": "Java",
    "chapterCount": 10
}
	 */
	
	@RequestMapping("/courseDefaults")
	public Course getCourseDefaults(@RequestParam (value="name",required=false) String name,
			@RequestParam (value="chapterCount",required=false) int chapterCount
			) {
		return new Course(defaultCourse,defaultChapterCount);
	}
	@Autowired
	private CourseConfiguration courseConfiguration;
	@RequestMapping("/configProperties")
	public HashMap<String,Object> getConfigProperties() {
	
		HashMap<String,Object> hashMap = new HashMap<String,Object>();
		hashMap.put("name", courseConfiguration.getName());
		hashMap.put("college",courseConfiguration.getCollege());
		hashMap.put("duration", courseConfiguration.getDuration());
		hashMap.put("chapterCount", courseConfiguration.getChapterCount());
		
		return hashMap;
		
	}
	
	
	
}
