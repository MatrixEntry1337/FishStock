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
			templateUrl: "Ang/templates/nav.html",
			onEnter: function($state, authFtry){
                if(authFtry.checkLogin())
                    $state.go('user_account.home');}
		})
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
			templateUrl: "Ang/templates/accountNav.html",
			onEnter: function($state, authFtry){
				if(!authFtry.checkLogin())
					$state.go("app.login");},
			resolve: {
	            userData: function(accountFtry){
	            	accountFtry.getUserData();
	            }
	        }
		})
		.state("user_account.home",{
			url: "/home",
			templateUrl: "Ang/templates/accountHome.html",
			controller: "accountHomeCtrl"});
		
	//    use the HTML5 History API
	//    $locationProvider.html5Mode(true);
});