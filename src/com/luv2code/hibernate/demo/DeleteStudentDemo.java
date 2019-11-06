package com.luv2code.hibernate.demo;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;

public class DeleteStudentDemo {
	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			int studentId = 3017;

			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrieve student based on the id : primary key
			// Table name with primary key as arguments
			
			System.out.println("\nGetting student with the id : " + studentId);
			Student myStudent = session.get(Student.class, studentId);

			// delete student
			//System.out.println("Deleting the student : " + myStudent);
			//session.delete(myStudent);
			
			// delete student with id=x
			int x = 3019;
			System.out.println("Deleting student with Id: "+x);
			session.createQuery("Delete from Student where id="+x).executeUpdate();

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!!!");
		} finally {
			// factory.close();
		}
	}
}
