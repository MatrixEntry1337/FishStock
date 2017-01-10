angular.module("account").controller('accountHomeCtrl', function($scope, $log, accountFtry){
	$scope.user = accountFtry.data;
});