package me.learning.jpa.repository;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import me.learning.jpa.entity.Course;
import me.learning.jpa.entity.Review;

@Repository
@Transactional
public class CourseRepository {

	@Autowired
	EntityManager entityManager;

	public Course findById(Long id) {
		return entityManager.find(Course.class, id);
	}

	public void deleteById(Long id) {
		entityManager.remove(findById(id));
	}

	public void learnEM() {
		Course course = new Course("Test JPA");
		entityManager.persist(course);
		Course course1 = findById(10001L);
		course1.setName("Test JPA 2");
	}

	public void addCodedReviewsForCourse() {
		Course course1 = findById(10002L);
		Review review = new Review("Great course content", "5.0");
		Review review1 = new Review("Detailed Course", "4.7");
		review.setCourse(course1);
		review1.setCourse(course1);
		course1.addReview(review1);
		course1.addReview(review);

		entityManager.persist(review);
		entityManager.persist(review1);
	}

	public void addReviewsForCourse(Long courseId, List<Review> reviews) {
		Course course1 = findById(10001L);
		for (Review review : reviews) {
			review.setCourse(course1);
			course1.addReview(review);
			entityManager.persist(review);
		}
	}
}
