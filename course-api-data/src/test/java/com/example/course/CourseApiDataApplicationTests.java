	package com.example.course;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.course.dao.CourseRepository;
import com.example.course.service.CourseService;
import com.example.course.topic.bo.Course;

@RunWith(SpringRunner.class)
@SpringBootTest
class CourseApiDataApplicationTests {

	@InjectMocks
	private CourseService courseService;
	@Mock
	private CourseRepository courseRepository;

	
	@BeforeEach
    void setMockOutput() {
		List<Course>  coursesList = new ArrayList<>();
		coursesList.add(new Course("1","java","java"));
		coursesList.add(new Course("2","test","test"));
		when(courseRepository.findAll()).thenReturn(coursesList);
    }
	
	@Test
	void contextLoads() {
		assertEquals(2, courseService.getAllCourse().size());
	}

}
