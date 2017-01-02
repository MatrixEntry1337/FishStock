publicModule.controller('publicCtrl', function($scope, publicFtry, $log, $http){
	$log.log("Started Public Controller");
	
	$scope.appName = publicFtry.getAppName();
	
	$scope.about = publicFtry.getAbout();
	
	$scope.authors = publicFtry.getAuthors();
	
	$scope.version = publicFtry.getVersion();
	
	//login func ?
	$scope.loginFormData = {}
	
	$scope.processLoginForm = function () {
		$http({
			method  : 'POST',
			URL     : 'login.do',
			data    : JSON.stringify($scope.loginFormData)
				})
			.success(function(data){
				console.log(data);
			});
	};
	
	
	
});