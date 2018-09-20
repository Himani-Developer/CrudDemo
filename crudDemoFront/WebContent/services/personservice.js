/**
 * personservice
 * $http is a service in agular js
 * $http is used to make http request
 */

app.factory('personService',function($http){
	var personService={}  //initialisation
	
	personService.getAllPersons=function(){
		//make rest call
		//call the middleware using $http service object
		var url="http://localhost:8081/crudDemoMiddleware/getallpersons"
		return $http.get(url)
	}
	
	
	
	personService.savePerson=function(person){
		var url="http://localhost:8081/crudDemoMiddleware/saveperson";
		return $http.post(url,person)
	}
	
	
	personService.deletePerson=function(id){
		var url="http://localhost:8081/crudDemoMiddleware/deleteperson/"+id;
		return $http['delete'](url)
	}
	
	
	personService.getPerson=function(id){
		var url="http://localhost:8081/crudDemoMiddleware/getperson/"+id;
		return $http.get(url)
	}
	
	personService.updatePerson=function(person){
		var url="http://localhost:8081/crudDemoMiddleware/updateperson"
		return $http.put(url,person)
	}
	
	return personService;
})