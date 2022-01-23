package com.in28minutes.jpa.hibernate.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.in28minutes.jpa.hibernate.demo.DemoApplication;
import com.in28minutes.jpa.hibernate.demo.entity.Course;
import com.in28minutes.jpa.hibernate.demo.entity.Student;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = DemoApplication.class)
class JPQLTest {
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	@Autowired
	EntityManager em;

	@Test
	void contextLoads() {
		LOGGER.info("Test is running");
	}

	@Test
	void jpql_basic() {
		Query query = em.createNamedQuery("get_all_courses");
		List resultList = query.getResultList();
		LOGGER.info("select c from Course -> {}", resultList);
	}

	@Test
	void jpql_typed() {
		TypedQuery<Course> query = em.createNamedQuery("get_all_courses", Course.class);
		List<Course> resultList = query.getResultList();
		LOGGER.info("TYPED select c from Course -> {}", resultList);
	}

	@Test
	void jpql_where() {
		TypedQuery<Course> query = em.createNamedQuery("get_all_courses_with_where_clause", Course.class);
		List<Course> resultList = query.getResultList();
		LOGGER.info("select c from Course c where name = 'History' -> {}", resultList);
	}

	// Course without student
	@Test
	void jpql_course_without_student() {
		TypedQuery<Course> query = em.createQuery("Select c from Course c where c.students is empty", Course.class);
		List<Course> resultList = query.getResultList();
		LOGGER.info("select c from course c where c.students is empty -> {}", resultList);
	}

	// Course with atleast 2 student
	@Test
	void jpql_course_with_atleast_2_student() {
		TypedQuery<Course> query = em.createQuery("Select c from Course c where size(c.students) >= 2", Course.class);
		List<Course> resultList = query.getResultList();
		LOGGER.info("Select c from Course c where size(c.students) >= 2 -> {}", resultList);
	}

	// Course ordered by student(By default = ascending)
	@Test
	void jpql_courses_ordered_by_student() {
		TypedQuery<Course> query = em.createQuery("Select c from Course c order by size(c.students)", Course.class);
		List<Course> resultList = query.getResultList();
		LOGGER.info("Select c from Course c order by size(c.students) -> {}", resultList);
	}

	// Student whose passport contain '123'
	@Test
	void jpql_student_whose_passport_in_a_pattern() {
		TypedQuery<Student> query = em.createQuery("Select s from Student s where s.passport.number like '%123%'",
				Student.class);
		List<Student> resultList = query.getResultList();
		LOGGER.info("Select s from Student s where s.passport.number like '%1234%' -> {}", resultList);
	}

}
