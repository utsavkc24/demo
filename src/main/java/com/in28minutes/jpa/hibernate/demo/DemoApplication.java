package com.in28minutes.jpa.hibernate.demo;

import java.math.BigDecimal;

import com.in28minutes.jpa.hibernate.demo.entity.FullTimeEmployee;
import com.in28minutes.jpa.hibernate.demo.entity.PartTimeEmployee;
import com.in28minutes.jpa.hibernate.demo.repository.CourseRepository;
import com.in28minutes.jpa.hibernate.demo.repository.EmployeeRepository;
import com.in28minutes.jpa.hibernate.demo.repository.StudentRepository;

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

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Course course = courseRepository.findById(10001L);
		// LOGGER.info("Course with id 100001 --> " + course.getName());

		// Course course = courseRepository.save(new Course("DSA"));
		// LOGGER.info("Saving course .... " + course.getName());

		// courseRepository.playWithEntityManager();

		// studentRepository.saveStudentWithPassport();
		// courseRepository.addHardcodedReviewForCourses();

		// List<Review> reviews = new ArrayList<>();
		// reviews.add(new Review("5", "Very Good"));
		// reviews.add(new Review("1", "Not so good"));

		// courseRepository.addReviewForCourses(10003L, reviews);

		// studentRepository.insertStudentAndCourse(new Student("Jonas"), new
		// Course("Time travel"));

		employeeRepository.insert(new PartTimeEmployee("Foo", new BigDecimal("50")));
		employeeRepository.insert(new FullTimeEmployee("Bar", new BigDecimal("10000")));

		LOGGER.info("Full Time employees -> {}", employeeRepository.retrieveAllFullTimeEmployees());
		LOGGER.info("Part Time employees -> {}", employeeRepository.retrieveAllPartTimeEmployees());

	}

}
