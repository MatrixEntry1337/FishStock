/**
 * authentication factory
 * - handles all authentication requests  
 */
angular.module('auth')
.factory('authFtry', function($http, $log){
	$log.log("Started Auth Factory");
	
	var auth = {};
	
	auth.loggedIn = false;
	
	auth.checkLogin = function(){
		return this.loggedIn;
	};
	
	auth.login = function (loginFormData, successFunc, failureFunc) {
		$http.post('/FishStock/login.do', loginFormData)
		.then(function(response){
			$log.log("Get all -- response object: ");
			$log.log(response.data);
			successFunc(response);
			auth.loggedIn = true;
		})
		.catch(function(response){
			failureFunc(response);
		})
		.finally($log.log("Always runs"));
	};
	
	return auth;
});