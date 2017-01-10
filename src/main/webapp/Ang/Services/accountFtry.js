angular.module('account').factory('accountFtry', function($http, $log){
	var account;
	
	account.data;
	
	account.getUserData = function(){
		$http.get('/getUserData')
			.then(function(response){
				$log.log("Get all -- response object: ");
				$log.log(response.data);
				account.data = response.data;
			})
			.catch(function(response){
				$log.log("There was an error, error status: " + response.status);
			});
	};
	
	return account;
});