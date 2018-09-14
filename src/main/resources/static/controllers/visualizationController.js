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

    $scope.stackOverFlowTab = function () {
        $location.path("/stackoverflow")
    };

    $scope.accountTab = function () {
        $location.path("/account")
    }

});