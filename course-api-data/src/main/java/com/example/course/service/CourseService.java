package com.example.course.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.course.dao.CourseRepository;
import com.example.course.topic.bo.Course;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourse() {
		List<Course>  courses = new ArrayList<>();
		courseRepository.findAll().forEach(courses::add);
		String a = "12345";
		
		return courses;
	}
	
	public Course getCourse(String id) {
		return courseRepository.findById(id).get();
	}
	
	public Course addCourse(Course course) {
		System.out.println("ADD topic"+course);
		 return courseRepository.save(course);
	}

}
