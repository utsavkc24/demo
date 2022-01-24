package com.in28minutes.jpa.hibernate.demo.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import com.in28minutes.jpa.hibernate.demo.DemoApplication;
import com.in28minutes.jpa.hibernate.demo.entity.Course;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = DemoApplication.class)
public class CourseSpringDataRepositoryTest {
    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CourseSpringDataRepository courseSpringDataRepository;

    @Test
    public void findById() {
        Optional<Course> courseOptional = courseSpringDataRepository.findById(10001L);
        assertTrue(courseOptional.isPresent());
        LOGGER.info("checking course exists or not {}", courseOptional.isPresent());
    }

    @Test
    public void playWithSpringDataJpa() {
        // Save
        Course course = new Course("AI");
        courseSpringDataRepository.save(course);

        // Update
        course.setName("AI - Updated");
        courseSpringDataRepository.save(course);

        // Find all
        LOGGER.info("Courses -> {}", courseSpringDataRepository.findAll());

        // Find no. of rows
        LOGGER.info("No of courses -> {}", courseSpringDataRepository.count());

    }
}
