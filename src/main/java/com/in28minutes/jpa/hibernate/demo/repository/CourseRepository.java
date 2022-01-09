package com.in28minutes.jpa.hibernate.demo.repository;

import javax.persistence.EntityManager;

import com.in28minutes.jpa.hibernate.demo.entity.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CourseRepository {

    @Autowired
    EntityManager entityManager;

    public Course findById(long id) {
        return entityManager.find(Course.class, id);
    }
}
