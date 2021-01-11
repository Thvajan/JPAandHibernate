package me.learning.jpa.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import me.learning.jpa.JpaApplication;
import me.learning.jpa.entity.Course;

@SpringBootTest(classes = JpaApplication.class)
public class CourseSpringDataRepositoryTest {

	@Autowired
	CourseSpringDataRepository repository;

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Test
	void findById_CoursePresent() {
		Optional<Course> courseOptional = repository.findById(10001L);
		assertTrue(courseOptional.isPresent());
		log.info("Running findById_CoursePresent -> {}", courseOptional.isPresent());
	}

	@Test
	void findById_CourseNotPresent() {
		Optional<Course> courseOptional = repository.findById(110001L);
		assertFalse(courseOptional.isPresent());
		log.info("Running findById_CourseNotPresent -> {}", courseOptional.isPresent());
	}

	@Test
	void playingWithSpringDataRepository() {
//		Course course = new Course("Primitive Survival Skils");
//		repository.save(course);
//		course.setName("Primitive Survival Skils - Updated");
//		repository.save(course);
		log.info("Courses -> {}", repository.findAll());
		log.info("Count ", repository.count());
	}
}
