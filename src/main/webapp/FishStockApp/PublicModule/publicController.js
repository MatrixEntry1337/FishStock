publicModule.controller('publicCtrl', function($scope, publicFtry, $log, $http){
	$log.log("Started Public Controller");
	
	$scope.appName = publicFtry.getAppName();
	
	$scope.about = publicFtry.getAbout();
	
	$scope.authors = publicFtry.getAuthors();
	
	$scope.version = publicFtry.getVersion();
});