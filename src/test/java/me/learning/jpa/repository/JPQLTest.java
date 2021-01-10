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
import me.learning.jpa.entity.Student;

@SpringBootTest(classes = JpaApplication.class)
public class JPQLTest {

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

	@Test
	void findStudentsWithPassportsWithPattern() {
		Query createQuery = em.createQuery("Select s from Student s where s.passport.number like '%234%32'",
				Student.class);
		log.info("findStudentsWithPassportsWithPattern -> {}", createQuery.getResultList());
	}

	/*
	 * In JPQL the following can be used:
	 * 
	 * like between start_number to end_number is null upper, lower, trim, length
	 * 
	 * 
	 * join - Select c,s from Course c JOIN c.students s -> Returns only courses
	 * with Students left join - Select c,s from Course c LEFT JOIN c.students s ->
	 * Returns all courses with and without Students cross join - Select c,s from
	 * Course c,Student s - > match all courses with all students(Cartesian Product)
	 */
	@Test
	void joinTest() {
		Query createQuery = em.createQuery("Select c,s from Course c JOIN c.students s");
		List<Object[]> resultList = createQuery.getResultList();
		log.info("joinTest.Size() -> {}", resultList.size());
		for (Object[] result : resultList) {
			log.info("==================================================");
			log.info("Course -> {} Student -> {}", result[0], result[1]);
		}
	}
	
	@Test
	void leftJoinTest() {
		Query createQuery = em.createQuery("Select c,s from Course c left join c.students s");
		List<Object[]> resultList = createQuery.getResultList();
		log.info("joinTest.Size() -> {}", resultList.size());
		for (Object[] result : resultList) {
			log.info("==================================================");
			log.info("Course -> {} Student -> {}", result[0], result[1]);
		}
	}
	
	@Test
	void crossJoinTest() {
		Query createQuery = em.createQuery("Select c,s from Course c , Student s");
		List<Object[]> resultList = createQuery.getResultList();
		log.info("joinTest.Size() -> {}", resultList.size());
		for (Object[] result : resultList) {
			log.info("==================================================");
			log.info("Course -> {} Student -> {}", result[0], result[1]);
		}
	}

}
