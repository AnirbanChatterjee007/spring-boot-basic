package com.example.course.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.course.service.CourseService;
import com.example.course.topic.bo.Course;

@RestController
@RequestMapping("/api")
public class CourseController {
	
	Logger log = LoggerFactory.getLogger(CourseController.class);

	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/hello")
	public String sayHi() {
		return "HI ANIRBAN";
	}
	
	

	@RequestMapping("/course")
	public List<Course> getAllCourse() {
		log.debug("Get aall courses");
		return courseService.getAllCourse();
	}
	
	@RequestMapping("/course/{id}")
	public Course getTopic(@PathVariable String id) {
		return courseService.getCourse(id);
	}
	
	
	@RequestMapping(method =RequestMethod.POST, value="/addCourse")
	public Course addTopic(@RequestBody Course topic) {
		return courseService.addCourse(topic);
	}
}
