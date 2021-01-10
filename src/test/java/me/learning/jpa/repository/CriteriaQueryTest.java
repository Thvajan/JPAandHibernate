package me.learning.jpa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import me.learning.jpa.JpaApplication;
import me.learning.jpa.entity.Course;

@SpringBootTest(classes = JpaApplication.class)
public class CriteriaQueryTest {

	@Autowired
	private EntityManager em;

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Test
	void criteriaQueryBasic() {

		//"Select c from Course c"
		
		// 1. Use Criteria Builder to create a Criteria Query returning the expected
		// result object
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Course> criteriaQuery = criteriaBuilder.createQuery(Course.class);

		//2.Define Roots for tables which are involved in the query
		Root<Course> root = criteriaQuery.from(Course.class);
		
		//3. Define Predicates etc using CriteriaBuilder

		//4. Add Predicates etc to criteriaQuery

		//5. Build the Typed Query using the entity Manager and CriteriaQuery
		TypedQuery<Course> createQuery = em.createQuery(criteriaQuery.select(root));
		 
		List<Course> resultList = createQuery.getResultList();
		log.info("Typed Query -> {}", resultList);
	}

}
