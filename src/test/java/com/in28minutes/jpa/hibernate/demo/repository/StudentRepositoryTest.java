package com.in28minutes.jpa.hibernate.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.in28minutes.jpa.hibernate.demo.DemoApplication;
import com.in28minutes.jpa.hibernate.demo.entity.Student;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(classes = DemoApplication.class)
class StudentRepositoryTest {
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	@Autowired
	StudentRepository studentRepository;

	@Test
	void contextLoads() {
		LOGGER.info("Test is running");
	}

	@Test
	@Transactional
	void retrieveStudentAndPassport() {
		Student student = studentRepository.findById(2L);
		LOGGER.info("student passport number -> {}", student.getPassport());
	}
}
