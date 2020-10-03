package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;


public class UpdatingStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//creagte session factory
		SessionFactory factory = (SessionFactory) new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//Create Session
		Session session= factory.getCurrentSession();
		
		try {
			
			int studentId = 1;
			//use the session object to save java object
			session= factory.getCurrentSession();
			
			
			
			
			//Starte a transaction
			session.beginTransaction();
			
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("Updating Student");
			myStudent.setFirstName("Tory");
			
			//commit transaction
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
			
		}
		finally {
			factory.close();
		}
	}

}
