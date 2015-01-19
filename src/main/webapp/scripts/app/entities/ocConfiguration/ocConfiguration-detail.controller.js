'use strict';

angular.module('openclinicaApp')
    .controller('OcConfigurationDetailController', function ($scope, $stateParams, OcConfiguration) {
        $scope.ocConfiguration = {};
        $scope.load = function (id) {
            OcConfiguration.get({id: id}, function(result) {
              $scope.ocConfiguration = result;
            });
        };
        $scope.load($stateParams.id);
    });
