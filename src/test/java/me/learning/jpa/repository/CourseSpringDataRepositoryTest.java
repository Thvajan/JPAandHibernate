package me.learning.jpa.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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
	public void playingWithSpringDataRepository() {
//		Course course = new Course("Primitive Survival Skils");
//		repository.save(course);
//		course.setName("Primitive Survival Skils - Updated");
//		repository.save(course);
		log.info("Courses -> {}", repository.findAll());
		log.info("Count " + repository.count());
		log.info("Courses Sort desc-> {}", repository.findAll(Sort.by(Sort.Direction.DESC, "name")));
//		log.info("Courses Sort desc-> {}", repository.findAll(Sort.by(Sort.Direction.DESC, "name").and(Sort.by(Sort.Direction.DESC, "age"))));
	}
	
	
	@Test
	public void paginationDataJPATest() {
		PageRequest pageRequest = PageRequest.of(0, 3);
		Page<Course> page1 = repository.findAll(pageRequest);
		log.info("First Page -> {}", page1.getContent());
		Pageable pageable = page1.nextPageable();
		Page<Course> page2 = repository.findAll(pageable);
		log.info("Second Page -> {}", page2.getContent());
//		log.info("Courses Sort desc-> {}", repository.findAll(Sort.by(Sort.Direction.DESC, "name").and(Sort.by(Sort.Direction.DESC, "age"))));
	}
	
}
