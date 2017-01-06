angular.module('stocks')
.controller('stocksCtrl', function(stocksFtry, $scope, $log){
	$scope.getAll = stocksFtry.getAll();
	$scope.allStocks = stocksFtry.allStocks;
	$scope.selectStock = function(stock){
		$scope.selectedStock = stock;
	};
});