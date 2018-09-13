'use strict';

app.controller('LoginController', function ($scope, $rootScope, $location, LoginService) {
    LoginService.ClearCredentials();

    $scope.error = false;

    $scope.login = function () {
        LoginService.Login($scope.username, $scope.password, function (response) {
            if (response.data) {
                LoginService.SetCredentials($scope.username, $scope.password);
                $scope.error = false;
                $location.path('/account');
            } else {
                $scope.error = true;
            }
        });
    };
});