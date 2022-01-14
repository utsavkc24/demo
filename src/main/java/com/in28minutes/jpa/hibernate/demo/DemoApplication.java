package com.in28minutes.jpa.hibernate.demo;

import com.in28minutes.jpa.hibernate.demo.entity.Course;
import com.in28minutes.jpa.hibernate.demo.repository.CourseRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	@Autowired
	CourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Course course = courseRepository.findById(10001L);
		// LOGGER.info("Course with id 100001 --> " + course.getName());

		// Course course = courseRepository.save(new Course("DSA"));
		// LOGGER.info("Saving course .... " + course.getName());

		courseRepository.playWithEntityManager();
	}

}
