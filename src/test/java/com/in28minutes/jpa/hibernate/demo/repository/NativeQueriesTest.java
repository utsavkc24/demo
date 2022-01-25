package com.in28minutes.jpa.hibernate.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.in28minutes.jpa.hibernate.demo.DemoApplication;
import com.in28minutes.jpa.hibernate.demo.entity.Course;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = DemoApplication.class)
class NativeQueriesTest {
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private EntityManager em;

	@Test
	void contextLoads() {
		LOGGER.info("Test is running");
	}

	@Test
	void native_query_basic() {
		Query query = em.createNativeQuery("select * from course", Course.class);
		List resultList = query.getResultList();
		LOGGER.info("select * from course -> {}", resultList);
	}

	@Test
	void native_query_with_paramter() {
		Query query = em.createNativeQuery("select * from course where id = ?", Course.class);
		query.setParameter(1, 10001L);
		List resultList = query.getResultList();
		LOGGER.info("select * from course where id = ? -> {}", resultList);
	}

	@Test
	void native_query_with_named_paramter() {
		Query query = em.createNativeQuery("select * from course where name like :name", Course.class);
		query.setParameter("name", "Spring Boot");
		List resultList = query.getResultList();
		LOGGER.info("select * from course where id = :id -> {}", resultList);
	}

	@Test
	@Transactional
	void native_query_updated() {
		Query query = em.createNativeQuery("update Course set last_updated_time = sysdate()", Course.class);
		int noOfRowsAffected = query.executeUpdate();
		LOGGER.info("noOfRowsAffected -> {}", noOfRowsAffected);
	}

}
