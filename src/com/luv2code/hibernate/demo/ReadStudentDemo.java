package com.luv2code.hibernate.demo;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;


public class ReadStudentDemo {
	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// create a student object
			System.out.println("Creating a new student object...");
			Student tempStudent = new Student("Aman", "Singh", "aman@singh.com");

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the student...");
			System.out.println(tempStudent);
			session.save(tempStudent);

			// commit transaction
			session.getTransaction().commit();
			
			// MY NEW CODE		
			System.out.println("Saved student. Generate id: " + tempStudent.getId());
			
			//now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student based on the id ; primary key
			System.out.println("\nGetting student with the id : " + tempStudent.getId());
			
			Student myStudent = session.get(Student.class, tempStudent.getId()); // Table name with primary key as arguments
			
			System.out.println("Get complete : " + myStudent);
			
			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!!!");
		} finally {
//			factory.close();
		}
	}
}
