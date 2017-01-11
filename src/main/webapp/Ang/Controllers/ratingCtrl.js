angular.module('rating').controller(function($scope, ratingFtry, $log){
    $log.log("Started Public Controller");

    $scope.appName = publicFtry.getAppName();

    $scope.about = publicFtry.getAbout();

    $scope.authors = publicFtry.getAuthors();

    $scope.version = publicFtry.getVersion();

    //test
    
});