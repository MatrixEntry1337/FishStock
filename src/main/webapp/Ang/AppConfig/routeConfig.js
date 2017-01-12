// config for app
angular.module('FishStockApp')
	.config(function($stateProvider, $locationProvider, $urlRouterProvider
			){
		
	// go to home on startup
	$urlRouterProvider.otherwise('app/home');
	
	// app states
	$stateProvider
		// public area
		.state("app",{
			abstract: true,
			url: "/app",
			templateUrl: "Ang/templates/public/nav.html",
//		onEnter: function($state, authFtry){
//                if(authFtry.checkLogin()){
//                    $state.go('user_account.home');
//				}
//            }
		})
		.state("app.login", {
			url: "/login",
			templateUrl: "Ang/templates/public/login.html",
			controller: "authCtrl"})
		.state("app.home", {
			url: "/home",
			templateUrl: "Ang/templates/public/home.html",
			controller: "publicCtrl"})
		.state("app.allStocks", {
			url: "/all-stocks",
			templateUrl: "Ang/templates/public/stocks.html",
			controller: "pubStocksCtrl"})
		
		// user area
		.state("user_account",{
			abstract:true,
			url: "/user_account",
			templateUrl: "Ang/templates/private/nav.html",
//			onEnter: function($state, authFtry){
//				if(!authFtry.checkLogin())
//					$state.go("app.login");},
			resolve: {
	            userData: function(accountFtry){
	            	return accountFtry.getUserData();
	            
	            }
	        }
		})
		.state("user_account.home",{
			url: "/home",
			templateUrl: "Ang/templates/private/home.html",
			controller: "accountHomeCtrl"})
		.state("user_account.stocks",{
			url: "/stocks",
			templateUrl: "Ang/templates/private/stocks.html",
			controller: "accountStocksCtrl"})
		.state("user_account.myStocks",{
			url: "/myStocks",
			templateUrl: "Ang/templates/private/myStocks.html"
		});
		
	//    use the HTML5 History API
	//    $locationProvider.html5Mode(true);
});