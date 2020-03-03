package com.allanudemy.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.allanudemy.hibernate.demo.entity.Student;

public class DeleteStudentDemo {
	
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
				
					
					//delete student
					session.delete(myStudent);
					
					
					//commit the transaction, no hard requirement to do session.save on the object to retrieve it 
					session.getTransaction().commit();
					
					
					//new session
					session = factory.getCurrentSession();
					
					session.beginTransaction();
					
					session.createQuery("delete from Student where id=2").executeUpdate();

					session.getTransaction().commit();
					
					System.out.println("Done");
					
					
				} finally {
					factory.close();
				}
	}
	
}	
