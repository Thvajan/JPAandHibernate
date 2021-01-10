package me.learning.jpa.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class PartTimeEmployee extends Employee {

	private BigDecimal hourlyWage;

	public PartTimeEmployee(String name, BigDecimal hourlyWage) {
		super(name);
		this.hourlyWage = hourlyWage;
	}

	public PartTimeEmployee() {
	}

	@Override
	public String toString() {
		return "PartTimeEmployee [hourlyWage=" + hourlyWage + "]";
	}

}
