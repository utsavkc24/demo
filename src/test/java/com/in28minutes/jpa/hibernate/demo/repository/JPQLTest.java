package com.in28minutes.jpa.hibernate.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.in28minutes.jpa.hibernate.demo.DemoApplication;
import com.in28minutes.jpa.hibernate.demo.entity.Course;

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

}
