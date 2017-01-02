// This is a test module
// Public facing data
var loginModule = angular.module('loginModule', []);

// $log allows you to do console logs
// $http is your ajax call
// Factories and Services are the same thing
// This is your model in mvc
loginModule.factory('loginFtry', function($http, $log){
	$log.log("Started Login Factory");
	
	var public = {};
	
	var data = {
			appName: "FishStock",
			authors : "Kyle Chang Fatt, Osher Cohen, Ilya Siarheyeu",
			about: "This is a stock watch application built using Java EE and AngularJS",
			version: 0.1
	};
	
	
	public.login = function (loginFormData) {
		$http.post('/FishStock/login.do', loginFormData).then(
				function(response){
					console.log(response.data.result);
				},
				function(response){
					console.log('error');
					console.log(response);
				}
				
		);
	};
	
	public.getAppName = function(){
		return data.appName;
	};
	
	public.getAuthors = function(){
		return data.authors
	};
	
	public.getAbout = function(){
		return data.about;
	};
	
	public.getVersion = function(){
		return data.version;
	};
	
	return public;
});