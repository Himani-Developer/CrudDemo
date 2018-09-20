/**
 * 
 */

app.controller("PersonDetailsCtrl",function($scope,personService,$routeParams,$location){
	var id=$routeParams.id
	
	personService.getPerson(id).then(function(response){
		$scope.person=response.data
		
	},function(response){
		
		$scope.error=response.data
	})
	
$scope.updatePerson=function(person){
		
		personService.updatePerson(person).then(function(response){
			$location.path('/getallpersons')
			
		},function(response){
			$scope.error=response.data
		})
		
	}
	
})
	
