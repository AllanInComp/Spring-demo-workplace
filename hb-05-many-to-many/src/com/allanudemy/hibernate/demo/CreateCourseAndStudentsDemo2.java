package com.allanudemy.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.allanudemy.hibernate.demo.entity.Course;
import com.allanudemy.hibernate.demo.entity.Instructor;
import com.allanudemy.hibernate.demo.entity.InstructorDetail;
import com.allanudemy.hibernate.demo.entity.Review;
import com.allanudemy.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo2 {

	
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
			Student tempStudent = session.get(Student.class, 5);

			session.save(tempStudent);
			System.out.println("\nSaved student: "+tempStudent);
			
			//create students
			Course c1 = new Course ("How to Slay in math");
			Course c2 = new Course ("How to Slay in french");
			
		

			//add students to course
			tempStudent.AddCourse(c1);
			tempStudent.AddCourse(c2);

			
			//save students
			session.save(c1);
			session.save(c2);
			System.out.println("Saved courses: "+tempStudent.getCourses());
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
			
			
		} finally {
			session.close();
			factory.close();
		}
		
	}

	
}
