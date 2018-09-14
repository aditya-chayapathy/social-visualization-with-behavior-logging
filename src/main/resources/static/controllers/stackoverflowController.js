'use strict';

app.controller('StackOverFlowController', function ($scope, $location, $rootScope, $http) {
    if ($rootScope.userId === "" || $rootScope.username === "") {
        $location.path("/");
    }

    $scope.userId = $rootScope.userId;

    $scope.username = $rootScope.username;

    $scope.logout = function () {
        $http({
            method: 'POST',
            url: '/user/logUserOut?userId=' + $scope.userId
        }).then(function (response) {
            if (response) {
                $rootScope.userId = "";
                $rootScope.username = "";
                $location.path("/");
            }
        });
    };

    $scope.socialVisualizationTab = function () {
        $location.path("/visualization")
    };

    $scope.accountTab = function () {
        $location.path("/account")
    }

});