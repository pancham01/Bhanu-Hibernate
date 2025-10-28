package com.learning.hbn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.learning.hbn.entity.Employee;

public class Main {
	public static void main(String[] args) {
		Employee emp = new Employee(1,"Lokesh","male",98000);
			
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg1.xml").buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		
		session.persist(emp);
		tx.commit();
	}

}
