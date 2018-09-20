package com.niit.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.models.Person;

@Repository
@Transactional
public class PersonDAOImpl implements PersonDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public PersonDAOImpl() {
		System.out.println("PersonDAOimpl bean is created");
	}
	
	public List<Person> getAllPersons() {
		
		Session session=sessionFactory.getCurrentSession();
		Query query=(Query) session.createQuery("from Person");
		List<Person> persons=query.list();
		return persons;
	}

	public void addPerson(Person person) {
		Session session=sessionFactory.getCurrentSession();
		session.save(person);
		
	}

	public void deletePerson(int id) {
		Session session=sessionFactory.getCurrentSession();
		Person person=session.get(Person.class, id);
		if(person!=null)
		session.delete(person);
		
	}

	public Person getPerson(int id) {
		Session session=sessionFactory.getCurrentSession();
		Person person=session.get(Person.class, id);
		return person;
	}

	public void updatePerson(Person person) {
		Session session=sessionFactory.getCurrentSession();
		session.update(person);
		
	}
	
	

}
