package com.digit.hibernate.model;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;



public class HibernateManager {
	private Session session;
	public HibernateManager() {
		Configuration configuration = new Configuration().configure("adhar.cfg.xml");

		 

        ServiceRegistryBuilder builder = new ServiceRegistryBuilder().applySettings(configuration.getProperties());

 

        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.buildServiceRegistry());

 

        session = sessionFactory.openSession();

 

        System.out.println("Connected to Pf...");
		
	}
	
	
	// instering 
	  public void saveObject(Adhar a) {

		  

	        Transaction trn = session.beginTransaction();

	 

	        session.save(a);

	 

	        trn.commit();

	 

	        System.out.println("Object Saved!");

	 

	    }
	  
//	  
//	  // select * from employee
//	  public void selectAll() {
//		  
//		  Transaction t = session.beginTransaction();
//		  Query q = session.createQuery("from Employee");
//		  List list = q.list();
//		  Iterator itr = q.iterate();
//		  while(itr.hasNext()) {
//			  Employee s = (Employee) itr.next();
//			  System.out.println(s.getID()+" "+s.getName()+" "+s.getAge()+" "+s.getCompany());
//		  }
//		  t.commit();
//		  
//	  }
//	
	  //select * from Employee where id=id
	  // this is only applicable for working with the primary key (id) present in the table .
	  public Adhar selectSpecific(String id) {
		  Transaction t = session.beginTransaction();
		  Adhar s = (Adhar)session.get(Adhar.class, id);
		 if(s!=null) {
			 return s;
		 }
		 return null;
	  }
	  
//	  // select * from employee where name=name;
//	  public void selectSpecific() {
//		  
//		  Transaction t = session.beginTransaction();
//		  Query q = session.createQuery("from Employee where name=:name");
//		  q.setParameter("name", "Dibya");
//		  List list = q.list();
//		  Iterator itr = q.iterate();
//		  while(itr.hasNext()) {
//			  Employee s = (Employee) itr.next();
//			  System.out.println(s.getID()+" "+s.getName()+" "+s.getAge()+" "+s.getCompany());
//		  }
//		  t.commit();
//		  
//	  }
//	  
//	  //select * from employee where name=:name or company=:company order by name
//	  public void selectSpecificWithCondition()
//	  {
//		  Transaction t = session.beginTransaction();
//		  Query q = session.createQuery("from Employee where name=:name or company=:company order by name");
//		  q.setParameter("name", "Dibya");
//		  q.setParameter("company", "Digit");
//		  List list = q.list();
//		  Iterator itr = q.iterate();
//		  while(itr.hasNext()) {
//			  Employee s = (Employee) itr.next();
//			  System.out.println(s.getID()+" "+s.getName()+" "+s.getAge()+" "+s.getCompany());
//		  }
//		  t.commit();
//	  }
//	  
	  // Alter table employee Update name = name where id=id
	  // based on primary key
	  public boolean UpdateSpecific(String id,String name) {
		  Transaction t = session.beginTransaction();
		  Adhar s = (Adhar)session.get(Adhar.class, id);
		  s.setName(name);
		  session.update(s);
		  t.commit();
		  return true;
		 
	  }
	  
	  // 
	  public boolean DeleteSpecific(String id) {
		  Transaction t = session.beginTransaction();
		  Adhar s = (Adhar)session.get(Adhar.class, id);
		  try {
		  session.delete(s);
		  }catch(Exception e) {
			  return false;
		  }
		  t.commit();
		  return true;
		 // System.out.println(s.getID()+" "+s.getName()+" "+s.getAge()+" "+s.getCompany());
	  }
}
