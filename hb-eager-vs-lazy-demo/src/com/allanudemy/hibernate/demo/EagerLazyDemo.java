package com.allanudemy.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.allanudemy.hibernate.demo.entity.Course;
import com.allanudemy.hibernate.demo.entity.Instructor;
import com.allanudemy.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

	
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
			//shows EAGER loading or LAZY, need to tweak Instructor class @OneToMany fetch=FetchType.EAGER or .LAZY
			
			//start a transaction
			session.beginTransaction();
			
			Instructor tempInstructor = session.get(Instructor.class, 1);
			System.out.println("Instructor retrieved: "+tempInstructor);
			
			//this command fetches the courses before session closes, subsequent fetches to same courses will not trigger lazyException
			System.out.println("Courses: "+tempInstructor.getCourses());

			//close the session before retrieving courses, test differences between LAZY and EAGER fetch
			System.out.println("Session is now closed");
			
			//get course for instructor
			System.out.println("Courses: "+tempInstructor.getCourses());
			
			//commit transaction, if session is closed, can't commit
			session.getTransaction().commit();
			
			System.out.println("Done");
			
			
		} finally {
			session.close();
			factory.close();
		}
		
	}

	
}
