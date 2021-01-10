package me.learning.jpa.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import me.learning.jpa.entity.Course;
import me.learning.jpa.entity.Passport;
import me.learning.jpa.entity.Student;

@Repository
@Transactional
public class StudentRepository {

	@Autowired
	EntityManager entityManager;
 
	public Student findById(Long id) {
		return entityManager.find(Student.class, id);
	}

	public void deleteById(Long id) {
		entityManager.remove(findById(id));
	}

	public Student save(Student student) {
		if (student.getId() != null) {
			entityManager.merge(student);
		} else {
			entityManager.persist(student);
		}
		return student;
	}

	public void saveStudentWithPassport() {
		Passport passport = new Passport("M12345687");
		entityManager.persist(passport);

		Student student = new Student("Raghavan");
		student.setPassport(passport);
		entityManager.persist(student);
	}

	public void learnEM() {
		Student ctudent = new Student("Test JPA");
		entityManager.persist(ctudent);
		Student ctudent1 = findById(10001L);
		ctudent1.setName("Test JPA 2");
	}

	public void saveStudentWithCourse() {

		Student student = new Student("Prabhu");
		Course course = new Course("Veda");
		entityManager.persist(student);
		entityManager.persist(course);
		student.addCourse(course);
		course.addStudent(student);
		entityManager.persist(student);
	}
}
