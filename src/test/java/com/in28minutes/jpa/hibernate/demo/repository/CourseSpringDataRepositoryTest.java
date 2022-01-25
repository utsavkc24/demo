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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

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

        // Get the result in sorted form
        // Create sort criteria
        Sort sort = Sort.by(Sort.Direction.DESC, "name"); // Sort sort = Sort.by(Sort.Direction.DESC, "name").and(); you
                                                          // can use this 'and()' for secondary sorting - for eg they
                                                          // have same name
        LOGGER.info("Courses in desc order -> {}", courseSpringDataRepository.findAll(sort));

        // Implement Pagination
        PageRequest pageRequest = PageRequest.of(0, 3); // Create a page request of 3 page per size.

        Page<Course> firstPageRequest = courseSpringDataRepository.findAll(pageRequest); // Results for first page.
        LOGGER.info("First page -> {}", firstPageRequest.getContent()); // Display the result using .getContent();

        Pageable secondPageable = firstPageRequest.nextPageable();
        Page<Course> secondPage = courseSpringDataRepository.findAll(secondPageable); // Results for second page.
        LOGGER.info("Second page -> {}", secondPage.getContent()); // Display the result using .getContent();

        // Using custom method defined by us
        LOGGER.info("Course comes from custom method-> {}", courseSpringDataRepository.findByName("History"));
    }

    @Test
    @Transactional
    public void firstLevelCachingDemo() {
        Optional<Course> course = courseSpringDataRepository.findById(10001L);// Query is fired
        LOGGER.info("course is retrieved first time {}", course.get());

        // course is retrieved second time by using default first level cache
        Optional<Course> course1 = courseSpringDataRepository.findById(10001L);// Query is not fired
        LOGGER.info("course is retrieved second time by using default first level cache {}", course1.get());
    }
}
