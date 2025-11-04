package com.learning.hbn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.learning.hbn.configuration.HibernateConfiguration;
import com.learning.hbn.entity.Address;
import com.learning.hbn.entity.Employee;

public class Main {
	public static void main(String[] args) {
		Employee emp = new Employee("Ashish","Male",45454);
		
		Address add = new Address("Noida","UP");
		
		
		emp.setAddress(add);
		
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
//		session.persist(emp);
//		session.persist(add);
		
		System.out.println("Employee : "+session.get(Employee.class, 1));
		System.out.println("Address : "+session.get(Address.class, 1));
		
		tx.commit();
	}

}
