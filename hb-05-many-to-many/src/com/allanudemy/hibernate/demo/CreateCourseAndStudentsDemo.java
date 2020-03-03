package com.allanudemy.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.allanudemy.hibernate.demo.entity.Course;
import com.allanudemy.hibernate.demo.entity.Instructor;
import com.allanudemy.hibernate.demo.entity.InstructorDetail;
import com.allanudemy.hibernate.demo.entity.Review;
import com.allanudemy.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

	
	public static void main(String []args) {
		
		// create session factory
		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)

				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//start a transaction
			session.beginTransaction();
			
			//create a course
			Course tempCourse = new Course("Pacman - How To Score One Million Points");

			session.save(tempCourse);
			System.out.println("\nSaved course: "+tempCourse);
			
			//create students
			Student stu1 = new Student ("John","Doe","john@luv2code.com");
			Student stu2 = new Student ("Mary","Poppins","mary@luv2code.com");
			
		

			//add students to course
			tempCourse.addStudent(stu1);
			tempCourse.addStudent(stu2);
			
			//save students
			session.save(stu1);
			session.save(stu2);
			System.out.println("Saved Students: "+tempCourse.getStudents());
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
			
			
		} finally {
			session.close();
			factory.close();
		}
		
	}

	
}
