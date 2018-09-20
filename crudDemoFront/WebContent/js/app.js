/**
 * 
 */

var app=angular.module("app",['ngRoute'])
app.config(function($routeProvider){
	$routeProvider
	.when('/getallpersons',{controller:'PersonCtrl',templateUrl:'views/listofpersons.html'})
	.when('/saveperson',{controller:'PersonCtrl',templateUrl:'views/personform.html'})
	.when('/getperson/:id',{controller:'PersonDetailsCtrl',templateUrl:'views/viewperson.html'})
	.when('/getupdateform/:id',{controller:"PersonDetailsCtrl",templateUrl:"views/updateform.html"})
})