// main angular module 
var fishStockApp = angular.module('FishStockApp', ['ui.router']);

// config for app
fishStockApp.config(function($stateProvider, $urlRouterProvider){
	$urlRouterProvider.otherwise('home');
	
	// app states
	$stateProvider
		.state("home", {
			url: "/home",
			template: "/FishStockApp/templates/home.html",
			controller: ""
		});
	
	
});