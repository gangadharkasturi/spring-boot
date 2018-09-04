package com.udemy;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("course")
public class CourseConfiguration {
private String name;
private int chapterCount;
private String college;
private String duration;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getChapterCount() {
	return chapterCount;
}
public void setChapterCount(int chapterCount) {
	this.chapterCount = chapterCount;
}
public String getCollege() {
	return college;
}
public void setCollege(String college) {
	this.college = college;
}
public String getDuration() {
	return duration;
}
public void setDuration(String duration) {
	this.duration = duration;
}

}
