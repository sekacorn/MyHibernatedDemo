package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;


public class DeletingStudentDemo2 {

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
			
			int studentId = 7;
			//use the session object to save java object
			session= factory.getCurrentSession();
	
			//Starte a transaction
			session.beginTransaction();
			
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("Deleting the Student with" +studentId+" is "+myStudent+"\n");
			session.delete(myStudent);
			
			studentId =2;
			
			myStudent = session.get(Student.class, studentId);
			
			System.out.println("Deleting the Student with" +studentId+" is "+myStudent+"\n");
			session.delete(myStudent);
			
			session.getTransaction().commit();
			
			
		}
		finally {
			factory.close();
		}
	}

}
