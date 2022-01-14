package com.in28minutes.jpa.hibernate.demo.repository;

import javax.persistence.EntityManager;

import com.in28minutes.jpa.hibernate.demo.entity.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CourseRepository {

    @Autowired
    EntityManager entityManager;

    public Course findById(long id) {
        return entityManager.find(Course.class, id);
    }

    public void deleteById(long id) {
        entityManager.remove(findById(id));
    }

    public Course save(Course course) {
        if (course.getId() == null) {
            entityManager.persist(course);
        } else {
            entityManager.merge(course);
        }
        return course;
    }

    public void playWithEntityManager() {
        entityManager.persist(new Course("Spring Boot"));

        Course course = findById(10001L);
        course.setName("History - Updated");
    }
}
