/**
 * 
 */
angular.module('rating')
.factory('ratingFtry', function (input, $http, $log) {
    $log.log("Started rating Factory");
    $http({
        method: 'POST',
        url: '/addRating.do',
        data: input
    });
});