package com.luv2code.hibernate.demo;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.luv2code.hibernate.demo.entity.Student;

import java.util.List;

import org.hibernate.Session;

public class QueryStudentDemo {
	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// query students
			List<Student> theStudents = session.createQuery("from Student")
					.getResultList();

			// display students
			displayStudents(theStudents);

			// query students: lastName='Gupta' //use Javaproperty name, not column name
			theStudents = session
					.createQuery("from Student s where s.lastName='Gupta'").getResultList();

			// display students
			System.out.println("\n\nStudents who have last name Gupta");
			displayStudents(theStudents);
			
			// query students: lastName='Gupta' or firstName='Aman'//use Javaproperty name, not column name
			theStudents = session
					.createQuery("from Student s where s.lastName='Gupta' OR s.firstName='Aman'").getResultList();
			
			// display students
			System.out.println("\n\nStudents who have last name Gupta or first name as Aman");
			displayStudents(theStudents);
			
			
			// query students: email ends with genius.com //use Javaproperty name, not column name
			theStudents = session
					.createQuery("from Student s where s.email like '%genius.com'").getResultList();
			
			// display students
			System.out.println("\n\nStudents whoes email ends with genius.com");
			displayStudents(theStudents);
			
			// query students: email ends with gmail.com //use Javaproperty name, not column name
			theStudents = session
					.createQuery("from Student s where s.email like '%gmail.com'").getResultList();
			
			// display students
			System.out.println("\n\nStudents whoes email ends with gmail.com");
			displayStudents(theStudents);

			

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!!!");

		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}
}
