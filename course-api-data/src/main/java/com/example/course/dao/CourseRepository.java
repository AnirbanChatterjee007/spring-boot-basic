package com.example.course.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.course.topic.bo.Course;

public interface CourseRepository extends CrudRepository<Course,String> {

	
	
}
