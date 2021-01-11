package me.learning.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import me.learning.jpa.entity.Course;

public interface CourseSpringDataRepository extends JpaRepository<Course, Long> {

}
