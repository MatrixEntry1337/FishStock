/**
 * public factory
 * holds data for intro page
 */
angular.module('public')
.factory('publicFtry', function($http, $log){
	$log.log("Started Public Factory");
	
	var pub = {};
	
	var data ={
			appName: "FishStock",
			authors : "Kyle Chang Fatt, Osher Cohen, Ilya Siarheyeu",
			about: "This is a stock watch application built using Java EE and AngularJS",
			version: 0.1
	};
	
	pub.getAppName = function(){
		return data.appName;
	};
	
	pub.getAuthors = function(){
		return data.authors;
	};
	
	pub.getAbout = function(){
		return data.about;
	};
	
	pub.getVersion = function(){
		return data.version;
	};
	
	return pub;
});