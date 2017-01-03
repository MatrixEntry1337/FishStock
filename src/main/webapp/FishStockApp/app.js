// main angular module 
var fishStockApp = angular.module('FishStockApp', 
		['publicModule','ui.router', 'loginModule', 'stocksModule']);

// config for app
fishStockApp.config(function($stateProvider, $urlRouterProvider){
	
	// go to home on startup
	$urlRouterProvider.otherwise('login');
	
	// app states
	$stateProvider
		.state("login", {
			url: "/login",
			templateUrl: "FishStockApp/templates/login.html",
			controller: "loginCtrl"})
			
		.state("home", {
			url: "/home",
			templateUrl: "FishStockApp/templates/home.html",
			controller: "publicCtrl"
		})
		.state("allStocks", {
			url: "/allStocks",
			templateUrl: "FishStockApp/templates/stocks.html",
			controller: "stocksCtrl"
		});
});