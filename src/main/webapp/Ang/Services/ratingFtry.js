/**
 * 
 */
angular.module('rating')
.factory('ratingFtry', function ($http, $log) {
    $log.log("Started rating Factory");
    var req = {
        method: 'POST',
        url: '/addRating.do',
        headers: {
            'Content-Type': 'application/json'
        },
        data: {
            rating: 'rating',
            companyId:"companyId"
        }
    };
    $http(req);
});