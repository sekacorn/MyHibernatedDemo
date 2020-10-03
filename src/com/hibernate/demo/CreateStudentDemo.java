package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;


public class CreateStudentDemo {

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
			//use the session object to save java object
			System.out.println("Creating new student object");
			
			//Create a student object
			Student  tempStudent = new Student("Irene","Nakalyowa", "iNak@googler.com");
			
			
			
			//Starte a transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving");
			session.save(tempStudent);
			//commit transaction
			
			session.getTransaction().commit();
			System.out.println("done");
			
		}
		finally {
			factory.close();
		}
	}

}
