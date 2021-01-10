package me.learning.jpa.repository;

import java.util.List;

import javax.persistence.EntityManager;
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
}
