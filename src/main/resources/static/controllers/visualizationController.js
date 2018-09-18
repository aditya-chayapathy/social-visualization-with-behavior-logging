'use strict';

app.controller('StackOverFlowController', function ($scope, $location, $rootScope, $http) {
    if ($rootScope.userId === "" || $rootScope.username === "") {
        $location.path("/");
    }

    $scope.userId = $rootScope.userId;

    $scope.username = $rootScope.username;

    $scope.accountTab = function () {
        $location.path("/account")
    };

    var data = [{
        x: ['giraffes', 'orangutans', 'monkeys'],
        y: [20, 14, 23],
        type: 'bar'
    }];

    Plotly.newPlot('myDiv', data);

});