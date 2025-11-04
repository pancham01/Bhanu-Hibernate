package com.learning.hbn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.learning.hbn.configuration.HibernateConfiguration;
import com.learning.hbn.entity.Employee;

public class Main {
	public static void main(String[] args) {
		Employee emp = new Employee();

		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		
		System.out.println(session.createQuery("from empp",Employee.class).list());
		
		

//		session.load(emp, 20);
//		emp = session.get(Employee.class, 4);
//		System.out.println(emp);
		
//		emp.setName("Mahesh");
//		session.persist(emp);
//		session.persist(emp2);
//		emp.setId(3);
//		session.remove(emp);
		
		tx.commit();
	}

}
