package com.in28minutes.jpa.hibernate.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;

import com.in28minutes.jpa.hibernate.demo.DemoApplication;
import com.in28minutes.jpa.hibernate.demo.entity.Passport;
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
	StudentRepository repository;

	@Autowired
	EntityManager entityManager;

	@Test
	void contextLoads() {
		LOGGER.info("Test is running");
	}

	@Test
	@Transactional
	void retrieveStudentAndThenPassport() {
		Student student = entityManager.find(Student.class, 2L);
		LOGGER.info("student -> {}", student);
		LOGGER.info("student's passport number -> {}", student.getPassport());
	}

	@Test
	@Transactional
	void retrievePassportAndThenStudent() {
		Passport passport = entityManager.find(Passport.class, 40001L);
		LOGGER.info("passport -> {}", passport);
		LOGGER.info("student's name -> {}", passport.getStudent());
	}
}
