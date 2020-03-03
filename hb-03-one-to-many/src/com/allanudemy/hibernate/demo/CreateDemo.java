package com.allanudemy.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.allanudemy.hibernate.demo.entity.Instructor;
import com.allanudemy.hibernate.demo.entity.InstructorDetail;
import com.allanudemy.hibernate.demo.entity.Student;

public class CreateDemo {

	
	public static void main(String []args) {
		
		// create session factory
		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//start a transaction
			session.beginTransaction();
			
			//create objects
			Instructor tempInstructor = new Instructor("Madhu","Patel","madhu@luv2code.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://luv2code.com/madhu","Guitar");
			
			//associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			
			System.out.println("Saving instructor: "+tempInstructor);
			//save the instructor
			//will also save the details object because of CascadeType.ALL
			session.save(tempInstructor);
					
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
			
			
		} finally {
			factory.close();
		}
		
	}

	
}
