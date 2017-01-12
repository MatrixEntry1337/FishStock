angular.module('stocks')
.factory('stocksFtry', function($http, $log){
	var stocks = {};
	
	stocks.data = {};
	
	stocks.watchStocks = [];
	
	// get all stocks
	stocks.getAllData = function(){
		
		var allData = {};
		
		$http.post('/FishStock/getAll.do')
			.then(function(response){
				$log.log("Get all -- response object: ");
				$log.log(response.data);
				angular.forEach(response.data.stocks, function(each){
					each.history.reverse();
				});
				angular.copy(response.data, stocks.data);
				angular.copy(response.data, allData);
				
			})
			.catch(function(response){
				$log.log("There was an error, error status: " + response.status);
			});
		return allData;
	};
	
	// grab user stocks
	stocks.getUserStocks = function(){
		var data = [];
		
		$http.get('/FishStock/getWatchList.do')
			.then(function(response){
				$log.log("Get User Stocks -- response object: ");
				$log.log(response.data);
				angular.copy(response.data, stocks.watchStocks);
				angular.copy(response.data, data);
			})
			.catch(function(response){
				$log.log("There was an error, error status: " + response.status);
			});
		return data;
	};
	
	// add stock
	stocks.addStock = function(company, success){
		$http.post('/FishStock/addToWatch.do', company)
			.then(function(response){
				success();
			})
			.catch(function(response){
				$log.log("There was an error, error status: " + response.status);
			});
	};
	
	
	// remove stock
	stocks.removeStock = function(company){
		$http.get('/FishStock/removeFromWatch.do', company)
			.then(function(response){
				$log.log("Remove stock -- response object: ");
				$log.log(response.data);
			})
			.catch(function(response){
				$log.log("There was an error, error status: " + response.status);
			});
	};
	
	
	return stocks;
});