package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = (SessionFactory) new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

//Create Session
Session session= factory.getCurrentSession();

try {
//use the session object to save java object
System.out.println("Creating new  3 student objects");

//Create a student object
Student  tempStudent = new Student("Authur","Winkenshire", "awinkenshire@emailer.com");
Student  tempStudent2 = new Student("Jonny","Quackenbush", "drQuack@emailer.com");

Student  tempStudent3 = new Student("Pierre-Emerick","Aubameyang", "Auba14@emailer.com");



//Starte a transaction
session.beginTransaction();

//save the student object
System.out.println("Saving");
session.save(tempStudent);
session.save(tempStudent2);
session.save(tempStudent3);
//commit transaction

session.getTransaction().commit();
System.out.println("done");

}
finally {
factory.close();
}

		
	}

}
