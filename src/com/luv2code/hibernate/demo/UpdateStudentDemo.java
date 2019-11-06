package com.luv2code.hibernate.demo;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;


public class UpdateStudentDemo {
	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			int studentId = 7;
			
			//now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student based on the id : primary key
			System.out.println("\nGetting student with the id : " + studentId);
			
			Student myStudent = session.get(Student.class, studentId); // Table name with primary key as arguments
			
			System.out.println("Updating student...");
			myStudent.setFirstName("Jadugar");
			
			// commit transaction
			session.getTransaction().commit();
			
			
			// New Code
			
			// getting new session
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// updating lastName for all
			System.out.println("Updating lastName to Thakur for allstudent");
			session.createQuery("update Student set lastName='Thakur'").executeUpdate();
			
			//commit transaction
			session.getTransaction().commit();

			System.out.println("Done!!!");
		} finally {
//			factory.close();
		}
	}
}
