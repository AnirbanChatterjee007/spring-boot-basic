package com.example.course.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.course.dao.CourseRepository;
import com.example.course.topic.bo.Course;

@Service
public class CourseService {
	
	Logger log = LoggerFactory.getLogger(CourseService.class);
	
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourse() {
		//List<Course>  courses = new ArrayList<>();
		//courseRepository.findAll().forEach(courses::add);
		String a = "12345";
		log.debug("Getting all courses");
		return (List<Course>) courseRepository.findAll();
	}
	
	public Course getCourse(String id) {
		return courseRepository.findById(id).get();
	}
	
	public Course addCourse(Course course) {
		System.out.println("ADD topic"+course);
		 return courseRepository.save(course);
	}

}
