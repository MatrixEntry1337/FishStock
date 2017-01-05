/**
 * authentication factory
 * - handles all authentication requests  
 */
angular.module('auth')
.factory('authFtry', function($http, $log){
	$log.log("Started Auth Factory");
	
	var public = {};
	
	var data = {
			appName: "FishStock",
			authors : "Kyle Chang Fatt, Osher Cohen, Ilya Siarheyeu",
			about: "This is a stock watch application built using Java EE and AngularJS",
			version: 0.1
	};
	
	
	public.login = function (loginFormData, successFunc, failureFunc) {
		$http.post('/FishStock/login.do', loginFormData).then(successFunc, failureFunc);
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