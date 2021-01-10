package me.learning.jpa.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import me.learning.jpa.entity.Employee;
import me.learning.jpa.entity.FullTimeEmployee;
import me.learning.jpa.entity.PartTimeEmployee;

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

	public List<FullTimeEmployee> getAllFullTimeEmployees() {
		return entityManager.createQuery("Select e from FullTimeEmployee e", FullTimeEmployee.class).getResultList();
	}

	public List<PartTimeEmployee> getAllPartTimeEmployees() {
		return entityManager.createQuery("Select e from PartTimeEmployee e", PartTimeEmployee.class).getResultList();
	}
}
