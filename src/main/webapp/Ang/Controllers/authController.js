angular.module('auth')
.controller('authCtrl', function($scope, authFtry, $log){
	$log.log("Started Login Controller");
	
	$scope.loginFormData = {};
	
	$scope.login = function(){
		successFunc = function(response){
			console.log(response.data.result);
		};
		failureFunc = function(response){
			console.log('error');
			console.log(response);
		};
		authFtry.login($scope.loginFormData, successFunc, failureFunc);
	};
});