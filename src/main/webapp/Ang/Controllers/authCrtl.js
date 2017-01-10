angular.module('auth')
.controller('authCtrl', function($scope, authFtry, $log, $state){
	$log.log("Started Login Controller");
	
	$scope.loginFormData = {};
	
	$scope.login = function(){
		successFunc = function(response){
			console.log(response.data.result);
			if (response.data.result == 'success') {
				$state.go('app.home');
			}else{
				$scope.message = "Incorrect username and/or password";
			}
		};
		failureFunc = function(response){
			console.log('error');
			console.log(response);
		};
		authFtry.login($scope.loginFormData, successFunc, failureFunc);
	};
});