angular.module("account").controller('accountHomeCtrl', function($scope, $log, accountFtry, userData){
	$log.log(userData);
	$scope.user = accountFtry.data;
});