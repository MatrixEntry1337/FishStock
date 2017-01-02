loginModule.controller('loginCtrl', function($scope, loginFtry, $log){
	$log.log("Started Login Controller");
	
	$scope.appName = publicFtry.getAppName();
	
	$scope.about = publicFtry.getAbout();
	
	$scope.authors = publicFtry.getAuthors();
	
	$scope.version = publicFtry.getVersion();
	
	$scope.loginFormData = {}
	
	$scope.login = function(){
		loginFtry.login(loginFormData);
	}
	
});