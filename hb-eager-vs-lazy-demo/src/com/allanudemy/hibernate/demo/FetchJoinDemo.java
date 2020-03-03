package com.allanudemy.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.allanudemy.hibernate.demo.entity.Course;
import com.allanudemy.hibernate.demo.entity.Instructor;
import com.allanudemy.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

	
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
			
			//perform hibernate query with HQL, join tables together, get all data at once
			int id = 1;
			Query <Instructor> query = session.createQuery("select i from Instructor i "
					+"JOIN FETCH i.courses "   //also fetch the courses associated with each instructor
					+"where i.id =:theInstructorId"
					,Instructor.class);
			
			//set parameter on query "where i.id =:theInstructorId
			query.setParameter("theInstructorId", id);
			
			//execute and get instructor
			Instructor tempInstructor= query.getSingleResult();
			
			session.close();

			
			System.out.println(tempInstructor);
			
			//commit transaction, if session is closed, can't commit
			session.getTransaction().commit();
			
			System.out.println("Done");
			
			
		} finally {
			session.close();
			factory.close();
		}
		
	}

	
}
