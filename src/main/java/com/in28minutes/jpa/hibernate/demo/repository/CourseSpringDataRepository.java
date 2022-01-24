package com.in28minutes.jpa.hibernate.demo.repository;

import java.util.List;

import com.in28minutes.jpa.hibernate.demo.entity.Course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CourseSpringDataRepository extends JpaRepository<Course, Long> {

    // You can define your own custom method
    List<Course> findByNameAndId(String name, Long id);

    List<Course> findByName(String name);

    List<Course> countByName(String name);

    List<Course> deleteByName(String name);

    List<Course> findByNameOrderByIdDesc(String name);

    // And also custom Queries

    // Error coming
    // // // JPQL Query
    // @Query("Select c From Course where name like '%try'")
    // List<Course> courseWithTryInName();

    // Native Query
    @Query(value = "Select * From Course where name like '%try'", nativeQuery = true)
    List<Course> courseWithTryInNameUsingNativeQuery();

    // Named Query
    @Query(name = "get_all_courses_with_where_clause") // This named Query is defined in Course.java
    List<Course> returnCourseWithNamedQuery();
}
