'use strict';

angular.module('openclinicaApp')
    .controller('OcArchivedDatasetFileDetailController', function ($scope, $stateParams, OcArchivedDatasetFile) {
        $scope.ocArchivedDatasetFile = {};
        $scope.load = function (id) {
            OcArchivedDatasetFile.get({id: id}, function(result) {
              $scope.ocArchivedDatasetFile = result;
            });
        };
        $scope.load($stateParams.id);
    });
