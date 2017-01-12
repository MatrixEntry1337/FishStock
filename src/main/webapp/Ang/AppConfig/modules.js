// main angular module -- add module here after creating it
angular.module('FishStockApp', 
		['ui.router','chart.js', 'public', 'auth', 'stocks', 'rating', 'account']);

// public facing module
angular.module('public', []);

// auth module
angular.module('auth', []);

// stocks module
angular.module('stocks', []);

// rating module
angular.module('rating', []);

// user module
angular.module('account', []);
