package com.allanudemy.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.allanudemy.hibernate.demo.entity.Student;

public class UpdateStudentDemo {
	
	public static void main(String []args) {
		// create session factory
				SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
				
				//create session
				Session session = factory.getCurrentSession();
				
				try {
					
					//start a transaction
					session.beginTransaction();
					
					int studentId = 1;
					Student myStudent = session.get(Student.class, studentId);
				
					
					//update first name to "Scooby"
					System.out.println("Updating Student...");
					myStudent.setFirstName("Scooby");
					
					
					//commit the transaction, no hard requirement to do session.save on the object to retrieve it 
					session.getTransaction().commit();
								
					//new session
					session = factory.getCurrentSession();
					session.beginTransaction();
					
					//update email for all students
					System.out.println("\nUpdating email for all students to stud@concordia.ca");
					
					session.createQuery("update Student set email='stud@concordia.ca'").executeUpdate();
					
					session.getTransaction().commit();

					
					System.out.println("Done");
					
					
				} finally {
					factory.close();
				}
	}
	
}	
