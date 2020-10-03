package com.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;


public class QueryStudentDemo {

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
			
			
			
			//Starte a transaction
			session.beginTransaction();
			
			//query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			displayStudents(theStudents);
				
			System.out.println("\nThe Student's whose last name is Nsaya is \n");
			theStudents = session.createQuery("from Student s where s.lastName='Nsaya'").getResultList();
			
			displayStudents(theStudents);
			
			System.out.println("\nStudent's whose email ends with googler.com");
            theStudents = session.createQuery("from Student s where s.email like '%googler.com'").getResultList();
			
			displayStudents(theStudents);
			
			
		//Display the students
			
			session.getTransaction().commit();
			System.out.println("done");
			
		}
		finally {
			factory.close();
		}
	}

	public static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent: theStudents) {
			
			System.out.println(tempStudent);
		}
	}
	
	
	

}
