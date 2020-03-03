package com.allanudemy.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.allanudemy.hibernate.demo.entity.Course;
import com.allanudemy.hibernate.demo.entity.Instructor;
import com.allanudemy.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

	
	public static void main(String []args) {
		
		// create session factory
		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//start a transaction
			session.beginTransaction();
			
			//get the instructor from db
			Instructor tempInstructor = session.get(Instructor.class, 1);
			
			//Create course object
			Course c1 = new Course ("Air Guitar");
			Course c2 = new Course ("Piano");
			Course c3 = new Course ("Math");

			tempInstructor.add(c1);
			tempInstructor.add(c2);
			tempInstructor.add(c3);
			
			session.save(c1);
			session.save(c2);
			session.save(c3);
			session.save(tempInstructor);
			
			//Add courses to the instructor3 
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
			
			
		} finally {
			session.close();
			factory.close();
		}
		
	}

	
}
