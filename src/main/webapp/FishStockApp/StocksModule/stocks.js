var stocksModule = angular.module('stocksModule', []);

stocksModule.factory('stocksFtry', function($http, $log){
	var stocks = {};
	
	stocks.allStocks = {};
	
	stocks.getAll = function(){
		$http.post('/FishStock/getAll.do')
			.then(
					function(response){
						$log.log("Get all response object: ");
//						$log.log(response);
						$log.log("Success status: " + response.status);
						angular.copy(response.data, stocks.allStocks);
						$log.log(stocks.allStocks);
					},
					function(response){
						$log.log("There was an error, error status: " + response.status);
					}
			);
	};
	return stocks;
});