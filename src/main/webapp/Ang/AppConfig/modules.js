// main angular module 
angular.module('FishStockApp', 
		['ui.router', 'public', 'auth', 'stocks', 'rating']);

// public facing module
angular.module('public', []);

// auth module
angular.module('auth', []);

// stocks module
angular.module('stocks', []);

// rating module
angular.module('rating', []);

