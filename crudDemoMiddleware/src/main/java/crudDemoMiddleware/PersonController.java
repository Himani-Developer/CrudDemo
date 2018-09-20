package crudDemoMiddleware;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.niit.DAO.PersonDAO;
import com.niit.models.ErrorClazz;
import com.niit.models.Person;

@Controller
public class PersonController {
@Autowired
private PersonDAO personDAO;

public PersonController() {
	System.out.println("PersonController bean is created");
}

@RequestMapping(value="/getallpersons",method=RequestMethod.GET)
public ResponseEntity<?> getAllPersons(){
	
	List<Person> persons=personDAO.getAllPersons();
	if(persons.isEmpty())
	{
	ErrorClazz errorClazz=new ErrorClazz(2,"No Records Found");
	return new ResponseEntity<ErrorClazz>(errorClazz,HttpStatus.NOT_FOUND);
	}
	else
	{
		return new ResponseEntity<List<Person>>(persons,HttpStatus.OK);
	}
	
}


@RequestMapping(value="/saveperson", method=RequestMethod.POST)
public ResponseEntity<?> savePerson(@RequestBody Person person) {
	try {
		personDAO.addPerson(person);
		System.out.println(person.getId());
		return new ResponseEntity<Person>(person,HttpStatus.OK);
	}
	catch(Exception e) {
		ErrorClazz errorClazz=new ErrorClazz(1,"Unable to insert person details..may be email is null/duplicate");
		return new ResponseEntity<ErrorClazz>(errorClazz,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}

@RequestMapping(value="/getperson/{id}",method=RequestMethod.GET)
public ResponseEntity<?> getPerson(@PathVariable int id){
	Person person=personDAO.getPerson(id);
	if(person==null)
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	else
		return new ResponseEntity<Person>(person,HttpStatus.OK);
}


@RequestMapping(value="/deleteperson/{id}",method=RequestMethod.DELETE)
public ResponseEntity<?> deletePerson(@PathVariable int id){
	try {
	personDAO.deletePerson(id);
	return new ResponseEntity<Void>(HttpStatus.OK);
	}
	catch(Exception e) {
		ErrorClazz errorClazz=new ErrorClazz(3, "Unable to delete person details with id"+ id + e.getMessage());
		return new ResponseEntity<ErrorClazz>(errorClazz,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	}

@RequestMapping(value="/updateperson",method=RequestMethod.PUT)
public ResponseEntity<?> updatePerson(@RequestBody Person person){
	try {
		personDAO.updatePerson(person);	
		return new ResponseEntity<Person>(person,HttpStatus.OK);
	}
	catch(Exception e) {
		ErrorClazz errorClazz=new ErrorClazz(4, "Unable to update the person details"+ e.getMessage());
		return new ResponseEntity<ErrorClazz>(errorClazz,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}



}
