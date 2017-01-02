// main angular module 
var fishStockApp = angular.module('FishStockApp', [ 'publicModule','ui.router']);

// config for app
fishStockApp.config(function($stateProvider, $urlRouterProvider){
	
	// go to home on startup
	$urlRouterProvider.otherwise('home');
	
	// app states
	$stateProvider
		.state("home", {
			url: "/home",
			templateUrl: "FishStockApp/templates/home.html",
			controller: "publicCtrl"
		});
});