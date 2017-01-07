// config for app
angular.module('FishStockApp')
	.config(function($stateProvider, $locationProvider, $urlRouterProvider){
		
	// go to home on startup
	$urlRouterProvider.otherwise('app/home');
	
	// app states
	$stateProvider
		.state("app",{
			abstract: true,
			url: "/app",
			templateUrl: "Ang/templates/nav.html"})
		.state("app.login", {
			url: "/login",
			templateUrl: "Ang/templates/login.html",
			controller: "authCtrl"})
		.state("app.home", {
			url: "/home",
			templateUrl: "Ang/templates/home.html",
			controller: "publicCtrl"})
		.state("app.allStocks", {
			url: "/all-stocks",
			templateUrl: "Ang/templates/stocks.html",
			controller: "stocksCtrl"
		});
	
	// use the HTML5 History API
//    $locationProvider.html5Mode(true);
});