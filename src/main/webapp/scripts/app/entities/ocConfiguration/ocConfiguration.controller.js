'use strict';

angular.module('openclinicaApp')
    .controller('OcConfigurationController', function ($scope, OcConfiguration) {
        $scope.ocConfigurations = [];
        $scope.loadAll = function() {
            OcConfiguration.query(function(result) {
               $scope.ocConfigurations = result;
            });
        };
        $scope.loadAll();

        $scope.create = function () {
            OcConfiguration.save($scope.ocConfiguration,
                function () {
                    $scope.loadAll();
                    $('#saveOcConfigurationModal').modal('hide');
                    $scope.clear();
                });
        };

        $scope.update = function (id) {
            $scope.ocConfiguration = OcConfiguration.get({id: id});
            $('#saveOcConfigurationModal').modal('show');
        };

        $scope.delete = function (id) {
            $scope.ocConfiguration = OcConfiguration.get({id: id});
            $('#deleteOcConfigurationConfirmation').modal('show');
        };

        $scope.confirmDelete = function (id) {
            OcConfiguration.delete({id: id},
                function () {
                    $scope.loadAll();
                    $('#deleteOcConfigurationConfirmation').modal('hide');
                    $scope.clear();
                });
        };

        $scope.clear = function () {
            $scope.ocConfiguration = {key: null, value: null, description: null, version: null, id: null};
        };
    });
