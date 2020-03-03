package com.allanudemy.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.allanudemy.hibernate.demo.entity.Student;

public class GetStudentDemo {

	
	public static void main(String []args) {
		
		// create session factory
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//primary key of student
			int studentId = 1;
			
			//start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//use the session object to save java object
			System.out.println("Getting new student object...");
			Student tempStudent = session.get(Student.class, studentId);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Got student: "+tempStudent);
			
			
			System.out.println("Done");
			
			
		} finally {
			factory.close();
		}
		
	}
}
