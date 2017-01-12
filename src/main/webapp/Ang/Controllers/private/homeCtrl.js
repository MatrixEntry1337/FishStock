angular.module("account").controller('accountHomeCtrl', function($scope, $log, accountFtry, userData){
	$scope.user = userData;
});