package com.example.course.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.course.topic.bo.Topic;

public interface TopicRepository extends CrudRepository<Topic,String> {

	
	
}
