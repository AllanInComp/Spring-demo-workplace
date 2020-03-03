package com.allanudemy.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.allanudemy.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {
	
	public static void main(String []args) {
		// create session factory
				SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
				
				//create session
				Session session = factory.getCurrentSession();
				
				try {
					
					//create three student objects
					System.out.println("Creating three student object...");
					Student tempStudent1 = new Student ("John","Doe","jdoe@gmail.com");
					Student tempStudent2 = new Student ("John","Many","jmany@gmail.com");
					Student tempStudent3 = new Student ("John","Numerous","jnumerous@gmail.com");

					
					//start a transaction
					session.beginTransaction();
					
					//save the student object

					System.out.println("saving the student...");
					session.save(tempStudent1);
					session.save(tempStudent2);
					session.save(tempStudent3);
								
					//commit transaction
					session.getTransaction().commit();
					
					System.out.println("Done");
					
					
				} finally {
					factory.close();
				}
	}
	
}	
