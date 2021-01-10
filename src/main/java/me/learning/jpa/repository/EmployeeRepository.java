package me.learning.jpa.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import me.learning.jpa.entity.Employee;

@Repository
@Transactional
public class EmployeeRepository {

	@Autowired
	EntityManager entityManager;

	private Logger log = LoggerFactory.getLogger(this.getClass());

	public void insertEmployee(Employee employee) {
		entityManager.persist(employee);
	}

	public List<Employee> getAllEmployees() {
		return entityManager.createQuery("Select e from Employee e", Employee.class).getResultList();
	}
}
