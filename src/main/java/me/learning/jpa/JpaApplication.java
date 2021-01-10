package me.learning.jpa;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import me.learning.jpa.entity.Employee;
import me.learning.jpa.entity.FullTimeEmployee;
import me.learning.jpa.entity.PartTimeEmployee;
import me.learning.jpa.repository.CourseRepository;
import me.learning.jpa.repository.EmployeeRepository;
import me.learning.jpa.repository.StudentRepository;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Course course = courseRepository.findById(10002L);
//		courseRepository.learnEM();
//		log.info("FindByID: 10002 {}", course);
//		studentRepository.saveStudentWithPassport();
//		List<Review> reviews = new ArrayList<Review>();
//		Review review = new Review("Hard Course", "3.0");
//		Review review1 = new Review("Almost perfect", "4.9");
//		reviews.add(review1);
//		reviews.add(review);
//		courseRepository.addReviewsForCourse(10001L, reviews);
//		studentRepository.saveStudentWithCourse();
		Employee employee1 = new FullTimeEmployee("Hema", BigDecimal.valueOf(10000));
		Employee employee2 = new PartTimeEmployee("SadaaShiv", BigDecimal.valueOf(70));
		employeeRepository.insertEmployee(employee1);
		employeeRepository.insertEmployee(employee2);
//		log.info("getAllEmployees:-> {}", employeeRepository.getAllEmployees());
		log.info("getAllEmployees:-> {}", employeeRepository.getAllPartTimeEmployees());
		log.info("getAllEmployees:-> {}", employeeRepository.getAllFullTimeEmployees());
	}

}
