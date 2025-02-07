package com.allanudemy.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.allanudemy.hibernate.demo.entity.Instructor;
import com.allanudemy.hibernate.demo.entity.InstructorDetail;

public class GetInstructorDemo {

	
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
			
			int id= 2999;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, id);
		
			System.out.println(tempInstructorDetail.getInstructor());
			
		
					
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
			
			
		}catch(Exception exc) {
			exc.printStackTrace();
			
		}finally {
			session.close();
			factory.close();
		}
		
	}

}
