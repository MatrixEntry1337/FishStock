loginModule.controller('loginCtrl', function($scope, loginFtry, $log){
	$log.log("Started Login Controller");
	
	$scope.appName = loginFtry.getAppName();
	
	$scope.about = loginFtry.getAbout();
	
	$scope.authors = loginFtry.getAuthors();
	
	$scope.version = loginFtry.getVersion();
	
	$scope.loginFormData = {};
	
	$scope.login = function(){
		successFunc = function(response){
			console.log(response.data.result);
		};
		failureFunc = function(response){
			console.log('error');
			console.log(response);
		};
		loginFtry.login($scope.loginFormData, successFunc, failureFunc);
	};
});