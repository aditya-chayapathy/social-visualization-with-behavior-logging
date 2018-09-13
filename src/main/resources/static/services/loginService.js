'use strict';

app.service('LoginService', function ($http, $rootScope, $timeout) {
    var service = {};

    service.Login = function (username, password, callback) {
        $timeout(function () {
            $http({
                method: 'GET',
                url: '/user/checkIfUserExists?name=' + username + '&password=' + password
            }).then(function (response) {
                callback(response)
            })
        }, 1000);
    };

    service.SetCredentials = function (username, password) {
        $timeout(function () {
            $http({
                method: 'GET',
                url: '/user/getUserDetails?name=' + username + '&password=' + password
            }).then(function (response) {
                $rootScope.userDetails = {
                    userName: response.name,
                    password: response.password,
                    userId: response.id,
                    address: response.address
                }
            })
        }, 1000);
    };

    service.ClearCredentials = function () {
        $rootScope.userDetails = {};
    };

    return service;
});