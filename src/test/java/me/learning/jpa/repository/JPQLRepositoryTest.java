package me.learning.jpa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import me.learning.jpa.JpaApplication;
import me.learning.jpa.entity.Course;

@SpringBootTest(classes = JpaApplication.class)
public class JPQLRepositoryTest {

	@Autowired
	private EntityManager em;

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Test
	void findById_basic() {
		log.info("Select c from Course c -> {}", em.createQuery("Select c from Course c").getResultList());
	}

	@Test
	void findById_basic_typed() {
		TypedQuery<Course> createQuery = em.createQuery("Select c from Course c", Course.class);
		List<Course> resultList = createQuery.getResultList();
		log.info("Select c from Course c -> {}", resultList);
	}
	
	@Test
	void findCoursesWithoutStudents() {
		Query createQuery = em.createQuery("Select c from Course c where c.students is empty");
		log.info("findCoursesWithoutStudents -> {}", createQuery.getResultList());
	}
	
	@Test
	void findCoursesWithAtLeast2Students() {
		Query createQuery = em.createQuery("Select c from Course c where size(c.students) >=2");
		log.info("findCoursesWithAtLeast2Students -> {}", createQuery.getResultList());
	}
	
	@Test
	void findCoursesWithOrderByNoOfStudents() {
		Query createQuery = em.createQuery("Select c from Course c order by size(c.students) desc");
		log.info("findCoursesWithOrderByNoOfStudents -> {}", createQuery.getResultList());
	}
	
}
