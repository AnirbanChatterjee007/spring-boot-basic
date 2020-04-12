package com.example.course.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.course.dao.TopicRepository;
import com.example.course.topic.bo.Topic;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	/*
	 * private List<Topic> topics =new ArrayList<>( Arrays.asList( new
	 * Topic("1","Java","OCJP"), new Topic("2","C","C++"), new
	 * Topic("3","Python","Phy") ));
	 */
	
	public List<Topic> getAllTopics() {
		List<Topic>  topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		
		return topics;
	}
	
	public Topic getTopic(String id) {
		return topicRepository.findById(id).get();
	}
	
	public Topic addTopic(Topic topic) {
		System.out.println("ADD topic"+topic);
		 return topicRepository.save(topic);
	}

}
