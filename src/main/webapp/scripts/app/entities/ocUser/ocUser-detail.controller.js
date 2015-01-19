'use strict';

angular.module('openclinicaApp')
    .controller('OcUserDetailController', function ($scope, $stateParams, OcUser) {
        $scope.ocUser = {};
        $scope.load = function (id) {
            OcUser.get({id: id}, function(result) {
              $scope.ocUser = result;
            });
        };
        $scope.load($stateParams.id);
    });
