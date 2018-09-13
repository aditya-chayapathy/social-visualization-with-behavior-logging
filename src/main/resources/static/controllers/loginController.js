'use strict';

app.controller('LoginController', function ($scope, $location, $rootScope, $http) {
    $scope.error = false;

    $scope.login = function () {
        $http({
            method: 'POST',
            url: '/user/logUserIn?username=' + $scope.username + '&password=' + $scope.password
        }).then(function (response) {
            if (response.data) {
                $scope.error = false;
                $rootScope.userId = response.data.id;
                $rootScope.username = response.data.name;
                $location.path('/account');
            } else {
                $scope.error = true
            }
        });
    };
});