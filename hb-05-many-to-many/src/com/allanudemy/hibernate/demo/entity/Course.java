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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {
	
	//define fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="instructor_id")
	private Instructor instructor;

	@OneToMany(fetch= FetchType.LAZY,
			cascade= {CascadeType.ALL} //once delete course, delete all associated reviews			
			)
	@JoinColumn(name="course_id")
	private List <Review> reviews;
	
	
	@ManyToMany (fetch = FetchType.LAZY,
				cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH}
			)
	@JoinTable (name = "course_student",
				joinColumns = @JoinColumn (name = "course_id"),
				inverseJoinColumns = @JoinColumn (name = "student_id")
			)
	private List<Student> students;
	
	
	
	
	//define ctor
	public Course() {}
	
	public Course(String title) {
		this.title = title;
	}
	
	//define getter and setter 

	public int getId() {
		return id;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	
	//add convenience method to add review
	
	public void addReview(Review review) {
		if(this.reviews==null) {
			this.reviews=new ArrayList<>();
		}
		this.reviews.add(review);
	}
	
	public void addStudent(Student student) {
		if(this.students==null) {
			this.students=new ArrayList<>();
		}
		this.students.add(student);
	}
	
	

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", instructor=" + instructor + "]";
	}
	
	
	
	
	
	
	
}
