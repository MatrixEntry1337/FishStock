/**
 * 
 */
angular.module('stocks')
.factory('stocksFtry', function($http, $log){
	var stocks = {};
	
	stocks.data = {};
	
	stocks.getAll = function(){
		$http.post('/FishStock/getAll.do')
			.then(function(response){
				$log.log("Get all -- response object: ");
				$log.log(response.data);
				angular.forEach(response.data.stocks, function(each){
					each.history.reverse();
				});
				angular.copy(response.data, stocks.data);
			})
			.catch(function(response){
				$log.log("There was an error, error status: " + response.status);
			});
	};
	return stocks;
});