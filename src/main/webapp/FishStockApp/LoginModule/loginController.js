loginModule.controller('loginCtrl', function($scope, loginFtry, $log){
	$log.log("Started Login Controller");
	
	$scope.appName = loginFtry.getAppName();
	
	$scope.about = loginFtry.getAbout();
	
	$scope.authors = loginFtry.getAuthors();
	
	$scope.version = loginFtry.getVersion();
	
	$scope.loginFormData = {}
	
	$scope.login = function(){
		loginFtry.login($scope.loginFormData);
	}
	
});