package me.learning.jpa.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import me.learning.jpa.JpaApplication;
import me.learning.jpa.entity.Passport;
import me.learning.jpa.entity.Student;

@SpringBootTest(classes = JpaApplication.class)
public class StudentRepositoryTest {

	@Autowired
	private StudentRepository studentRepository;

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	@Test
	void findById() {
		Student student = studentRepository.findById(1L);
		log.info("Running student findById -> {}", student);
	}

	@Test
	public void getStudentWithPassport() {
		methodWithoutTransaction();
	}

	private void methodWithoutTransaction() {
		Student student = studentRepository.findById(2L);
		log.info("Running student findById -> {}", student);
		log.info("Passport for student findById -> {}", student.getPassport());
	}
	
	@Test
	@Transactional
	public void getPassportWithStudentInfo() {
		Passport passport = em.find(Passport.class,1L);
		log.info("Running passport findById -> {}", passport);
		log.info("student for Passport findById -> {}", passport.getStudent().getId());
	}
	
	@Test
	@Transactional
	public void getStudentAndCourse() {
		Student student = studentRepository.findById(50001L);
		log.info("Running student findById -> {}", student);
		log.info("Courses -> {}", student.getCourses());
	}
}
