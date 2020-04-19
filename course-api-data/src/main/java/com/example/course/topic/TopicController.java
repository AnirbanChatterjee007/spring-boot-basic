package com.example.course.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.course.service.TopicService;
import com.example.course.topic.bo.Topic;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api")
public class TopicController {

	
	
	@Autowired
	private TopicService topicService;

	@ApiOperation(value="Fetches all topics that are available",
			notes="First add and then fetch",
			response = Topic.class)
	@RequestMapping(method = RequestMethod.GET, value="/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}
	
	@ApiOperation(value="Add topics by topic ID",
			notes="Please provide ID",
			response = Topic.class)
	@RequestMapping(method = RequestMethod.GET, value="/topic/{id}")
	public Topic getTopic(@ApiParam(required =true) @PathVariable String id) {
		return topicService.getTopic(id);
	}
	
	@ApiOperation(value="Add topics",
			notes="Please provide all values",
			response = Topic.class)
	@RequestMapping(method =RequestMethod.POST, value="/addTopics")
	public Topic addTopic(@ApiParam(required =true) @RequestBody Topic topic) {
		return topicService.addTopic(topic);
	}
	
	
	
	
}
