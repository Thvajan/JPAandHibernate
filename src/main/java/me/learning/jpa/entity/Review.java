package me.learning.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author srive
 *
 */
@Entity
public class Review {

	@Id
	@GeneratedValue
	private Long id;

	private String description;

	private String rating;

	@ManyToOne
	private Course course;

	public Review() {
	}

	public Review(String description, String rating) {
		this.description = description;
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", description=" + description + ", rating=" + rating + "]";
	}

}
