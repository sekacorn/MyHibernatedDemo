package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;


public class ReadStudentDemo2 {

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
			Student  tempStudent = new Student("Will","Nsaya", "wNsaya@emailer.com");
			
			
			
			//Starte a transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving... "+tempStudent);
			session.save(tempStudent);
			//commit transaction
			
			session.getTransaction().commit();
			
			System.out.println("Saved Student Generated id: "+tempStudent.getId());
			// get a new session and start transaction
			session= factory.getCurrentSession();
			session.beginTransaction();
			
			
			//retrieve student based on the id: primary key
			System.out.println("\nGetting student with id: "+tempStudent.getId());
			Student myStudent= session.get(Student.class,  tempStudent.getId());
			
			System.out.println("Get complete: "+ myStudent);
			//commit the transaction
			
			session.getTransaction().commit();			
			System.out.println("done");
			
		}
		finally {
			factory.close();
		}
	}

}
