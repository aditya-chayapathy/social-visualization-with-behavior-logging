'use strict';

app.controller('VisualizationController', function ($scope, $location, $rootScope, $http) {
    if ($rootScope.userId === "" || $rootScope.username === "") {
        $location.path("/");
    }

    $scope.userId = $rootScope.userId;

    $scope.username = $rootScope.username;

    $http({
        method: 'GET',
        url: '/visualization/getKeyPressStats?userId=' + $scope.userId
    }).then(function (response) {
        var data = [{
            x: Object.keys(response.data),
            y: Object.values(response.data),
            type: 'bar'
        }];
        var layout = {
            autosize: false,
            width: 500,
            height: 500,
            margin: {
                l: 50,
                r: 50,
                b: 50,
                t: 50,
                pad: 4
            }
        };
        Plotly.newPlot('graph1', data, layout);
    });

    $http({
        method: 'GET',
        url: '/visualization/getKeyPressStats?userId=' + $scope.userId
    }).then(function (response) {
        var data = [{
            x: Object.keys(response.data),
            y: Object.values(response.data),
            type: 'bar'
        }];
        var layout = {
            autosize: false,
            width: 500,
            height: 500,
            margin: {
                l: 50,
                r: 50,
                b: 50,
                t: 50,
                pad: 4
            }
        };
        Plotly.newPlot('graph2', data, layout);
    });

    $http({
        method: 'GET',
        url: '/visualization/getKeyPressStats?userId=' + $scope.userId
    }).then(function (response) {
        var data = [{
            x: Object.keys(response.data),
            y: Object.values(response.data),
            type: 'bar'
        }];
        var layout = {
            autosize: false,
            width: 500,
            height: 500,
            margin: {
                l: 50,
                r: 50,
                b: 50,
                t: 50,
                pad: 4
            }
        };
        Plotly.newPlot('graph3', data, layout);
    });

    $http({
        method: 'GET',
        url: '/visualization/getKeyPressStats?userId=' + $scope.userId
    }).then(function (response) {
        var data = [{
            x: Object.keys(response.data),
            y: Object.values(response.data),
            type: 'bar'
        }];
        var layout = {
            autosize: false,
            width: 500,
            height: 500,
            margin: {
                l: 50,
                r: 50,
                b: 50,
                t: 50,
                pad: 4
            }
        };
        Plotly.newPlot('graph4', data, layout);
    });

    $http({
        method: 'GET',
        url: '/visualization/getKeyPressStats?userId=' + $scope.userId
    }).then(function (response) {
        var data = [{
            x: Object.keys(response.data),
            y: Object.values(response.data),
            type: 'bar'
        }];
        var layout = {
            autosize: false,
            width: 500,
            height: 500,
            margin: {
                l: 50,
                r: 50,
                b: 50,
                t: 50,
                pad: 4
            }
        };
        Plotly.newPlot('graph5', data, layout);
    });

    $scope.accountTab = function () {
        $location.path("/account")
    };

});