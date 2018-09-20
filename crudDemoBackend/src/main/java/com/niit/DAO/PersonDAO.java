package com.niit.DAO;

import java.util.List;

import com.niit.models.Person;

public interface PersonDAO {

	List<Person> getAllPersons();
	void addPerson(Person person);
	void updatePerson(Person person);
	void deletePerson(int id);
	Person getPerson(int id);
}
