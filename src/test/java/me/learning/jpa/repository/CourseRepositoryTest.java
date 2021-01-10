package me.learning.jpa.repository;

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import me.learning.jpa.JpaApplication;
import me.learning.jpa.entity.Course;

@SpringBootTest(classes = JpaApplication.class)
public class CourseRepositoryTest {

	@Autowired
	private CourseRepository courseRepository;

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Test
	void findById() {
		Course course = courseRepository.findById(10001L);
		log.info("Running findById -> {}", course);
	}

	@Test
	@DirtiesContext
	public void deleteById() {
		courseRepository.deleteById(10001L);
		Course course = courseRepository.findById(10001L);
		log.info("Running deleteById -> {}", course);
		assertNull(course);
	}

	@Test
	void findById1() {
		Course course = courseRepository.findById(10001L);
		log.info("Running findById -> {}", course);
	}
	
	@Test
	void findById11() {
		Course course = courseRepository.findById(10001L);
		log.info("Running findById -> {}", course);
	}
	
}
