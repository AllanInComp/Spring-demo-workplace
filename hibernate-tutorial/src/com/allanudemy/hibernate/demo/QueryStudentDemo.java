package com.allanudemy.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.allanudemy.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	
	public static void main(String []args) {
		
		// create session factory
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			//query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			//display the students
			displayStudents(theStudents);
						
			
			
			//query students whose last name is 'Doe'
			List<Student> theStudents2 = session.createQuery("from Student s where s.lastName='Doe'").getResultList();
			System.out.println("\nStudents with last name of doe");
			displayStudents(theStudents2);
			
			//query students whose last name is 'Doe' OR first name is 'Jake'
			System.out.println("\nStudents with last name of doe or first name of Jake");
			List<Student> theStudents3 = session.createQuery("from Student s where s.lastName='Doe' OR s.firstName='Jake'").getResultList();
			displayStudents(theStudents3);
			
			//query students whose last name is 'Doe' OR first name is 'Jake'
			System.out.println("\nStudents with email ending with @gmail.com");
			List<Student> theStudents4 = session.createQuery("from Student s where s.email LIKE '%gmail.com'").getResultList();
			displayStudents(theStudents4);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
			
			
		} finally {
			factory.close();
		}
		
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student st: theStudents) {
			System.out.println(st);
		}
	}
}
