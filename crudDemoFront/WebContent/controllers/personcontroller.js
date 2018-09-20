/**
 * PersonCtrl
 */

app.controller('PersonCtrl',function($scope,personService,$location){ //get PersonService from factory
	
	function getAllPersons(){
	personService.getAllPersons().then(function(response){
		$scope.persons=response.data  //response.data is Array of person onjects
		
	},function(response){
		
		$scope.error=response.data // response.data is ErrorClazz object
		console.log(response.data)
		console.log(response.status)
	})
	
	}
	
	
	$scope.savePerson=function(person){
		personService.savePerson(person).then(function(response){
			alert("Person details successfully Saved..")
			$scope.person=''
			//$location.path('/getallpersons')
			getAllPersons()
			
		},function(response){
			$scope.error=response.data;
			
		})
	}
	
	$scope.deletePerson=function(id){
		personService.deletePerson(id).then(function(response){
			getAllPersons()
		},function(response){
			$scope.error=response.data;
		})
	}
	
	
	getAllPersons()
})