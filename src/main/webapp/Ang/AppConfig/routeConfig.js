// config for app
angular.module('FishStockApp')
	.config(function($stateProvider, $locationProvider, $urlRouterProvider){
		
	// go to home on startup
	$urlRouterProvider.otherwise('app/home');
	
	// app states
	$stateProvider
		// public area
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
			controller: "stocksCtrl"})
		
		// user area
		.state("user_account",{
			abstract:true,
			url: "/user_account",
			templateURL: "Ang/templates/userNav.html",
			onEnter: function($state, authFtry){
				if(!authFtry.isLoggedIn())
					$state.go("app.login");
			}
		}).state("user_account.home",{
			url: "/home",
			templateUrl: "Ang/templates/userHome.html",
			controller: "userHomeCtrl"
		});
	
		
		
	// use the HTML5 History API
//    $locationProvider.html5Mode(true);
});