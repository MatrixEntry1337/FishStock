angular.module('account').factory('accountFtry', function($http, $log){
	var account = {};
	
	account.data;
	
	account.getUserData = function(){
		var data = {};
		
		$http.get('/FishStock/getuser.do')
			.then(function(response){
				$log.log("Get user data -- response object: ");
				$log.log(response.data);
				account.data = response.data;
				angular.copy(response.data, data);
			})
			.catch(function(response){
				$log.log("There was an error, error status: " + response.status);
			});
		return data;
	};
	
	return account;
});