var stocksModule = angular.module('stocksModule', []);

stocksModule.factory('stocksFtry', function($http, $log){
	var stocks = {};
	
	stocks.getAll = $http.post('/FishStock/getAll.do').then(function(data){
		$log.log(data);
	});
	
	return stocks;
});