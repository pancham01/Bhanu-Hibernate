package com.learning.hbn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.learning.hbn.configuration.HibernateConfiguration;
import com.learning.hbn.entity.Address;
import com.learning.hbn.entity.Employee;

public class Main {
	public static void main(String[] args) {
		Employee emp = new Employee("Vinay", "Male", 45454);
		Address add = new Address("GZB", "UP");
		emp.setAddress(add);
		add.setEmployee(emp);

		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		getEmpByIdWithAdd(session);
		getAddByIdWithEmp(session);
		
		
//		session.persist(emp);
//		session.persist(add);
		

		tx.commit();
	}

	public static void getEmpByIdWithAdd(Session session) {
		Employee employee = session.get(Employee.class, 1);
		System.out.println("employee : " + employee);
		System.out.println("employee.getAddress : " + employee.getAddress());

	}

	public static void getAddByIdWithEmp(Session session) {
		Address address = session.get(Address.class, 1);
		System.out.println("address : " + address);
		System.out.println("address.getEmployee : " + address.getEmployee());
	}
}
