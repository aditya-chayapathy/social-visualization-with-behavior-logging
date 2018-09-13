'use strict';

app.controller('AccountController', function ($scope, $location, $rootScope, $http) {
    $scope.userId = $rootScope.userId;
    $scope.username = $rootScope.username;
    $http({
        method: 'GET',
        url: '/login/getLoginInfoForUser?userId=' + $scope.userId + '&loginType=LOG_IN'
    }).then(function (response) {
        $scope.lastLoginDetails = response.data
    });
});