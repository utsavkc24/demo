package com.in28minutes.jpa.hibernate.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;

import com.in28minutes.jpa.hibernate.demo.entity.Course;
import com.in28minutes.jpa.hibernate.demo.entity.Review;
import com.in28minutes.jpa.hibernate.demo.entity.ReviewRating;

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

    public void addHardcodedReviewForCourses() {
        Course course = entityManager.find(Course.class, 10003L);

        Review review1 = new Review(ReviewRating.FIVE, "Very Good");
        Review review2 = new Review(ReviewRating.ONE, "Not so good");

        course.addReviews(review1);
        review1.setCourse(course);
        course.addReviews(review2);
        review2.setCourse(course);

        entityManager.persist(review1);
        entityManager.persist(review2);
    }

    public void addReviewForCourses(Long courseId, List<Review> reviews) {
        Course course = entityManager.find(Course.class, courseId);

        for (Review review : reviews) {
            course.addReviews(review);
            review.setCourse(course);
            entityManager.persist(review);
        }

    }
}
