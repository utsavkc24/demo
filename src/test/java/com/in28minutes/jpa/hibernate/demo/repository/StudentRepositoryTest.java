package com.in28minutes.jpa.hibernate.demo.repository;

import javax.persistence.EntityManager;

import com.in28minutes.jpa.hibernate.demo.DemoApplication;
import com.in28minutes.jpa.hibernate.demo.entity.Address;
import com.in28minutes.jpa.hibernate.demo.entity.Course;
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

	@Test
	@Transactional
	public void retrieveStudentAndTheCourse() {
		Student student = entityManager.find(Student.class, 20001L);
		LOGGER.info("student -> {}", student);
		LOGGER.info("Student's courses -> {}", student.getCourses());
	}

	@Test
	@Transactional
	public void retrieveCourseAndTheStudent() {
		Course course = entityManager.find(Course.class, 10001L);
		LOGGER.info("Course -> {}", course);
		LOGGER.info("Students -> {}", course.getStudents());
	}

	@Test
	@Transactional
	public void setAddressForStudent() {
		Student student = entityManager.find(Student.class, 20001L);
		student.setAddress(new Address("D105", "Street 2", "Gotham"));

		LOGGER.info("student -> {}", student);
		LOGGER.info("Student's courses -> {}", student.getCourses());
	}
}
