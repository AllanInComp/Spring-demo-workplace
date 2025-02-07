package com.allanudemy.hibernate.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Shows mapping of Entity class as well as its fields to a MySQL database table as well as its columns 
 * Done via hibernate API
 * @author Allan Yu
 *
 */
@Entity
@Table(name="student")
public class Student {
	
	@Id //this given field is a primary key 
	@GeneratedValue(strategy=GenerationType.IDENTITY) //allow database to handle the unique primary keys according to its rules (in this case auto-increment)
	@Column(name="id")
	private int id;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	@Column(name="email")
	private String email;
	
	@ManyToMany (fetch = FetchType.LAZY,
			cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH}
		)
	@JoinTable (name = "course_student",
				joinColumns = @JoinColumn (name = "student_id"),
				inverseJoinColumns = @JoinColumn (name = "course_id")
			)
	private List<Course> courses;

	
	public Student() {}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	//convenience methods

	
	public Student(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public void AddCourse(Course course) {
		if(this.courses==null) {
			this.courses=new ArrayList<>();
		}
		this.courses.add(course);
	}

	/**
	 * toString() method for debugging
	 */
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
	
	
	
	
	
}
