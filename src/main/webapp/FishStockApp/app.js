// main angular module 
var fishStockApp = angular.module('FishStockApp', [ 'publicModule','ui.router']);

// config for app
fishStockApp.config(function($stateProvider, $urlRouterProvider){
	
	// go to login on startup
	$urlRouterProvider.otherwise('login');
	
	// app states
	$stateProvider
		.state("login", {
			url: "login",
			templateUrl: "/FishStockApp/templates/login.html",
			controller: "publicCtrl"
		});
});