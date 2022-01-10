package com.in28minutes.jpa.hibernate.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.in28minutes.jpa.hibernate.demo.DemoApplication;
import com.in28minutes.jpa.hibernate.demo.entity.Course;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = DemoApplication.class)
class CourseRepositoryTest {
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	@Autowired
	CourseRepository courseRepository;

	@Test
	void findById_basic() {
		LOGGER.info("Test is running");
		Course course = courseRepository.findById(10001L);
		assertEquals("History", course.getName());
	}

}
