'use strict';

angular.module('openclinicaApp')
    .controller('OcArchivedDatasetFileController', function ($scope, OcArchivedDatasetFile) {
        $scope.ocArchivedDatasetFiles = [];
        $scope.loadAll = function() {
            OcArchivedDatasetFile.query(function(result) {
               $scope.ocArchivedDatasetFiles = result;
            });
        };
        $scope.loadAll();

        $scope.create = function () {
            OcArchivedDatasetFile.save($scope.ocArchivedDatasetFile,
                function () {
                    $scope.loadAll();
                    $('#saveOcArchivedDatasetFileModal').modal('hide');
                    $scope.clear();
                });
        };

        $scope.update = function (id) {
            $scope.ocArchivedDatasetFile = OcArchivedDatasetFile.get({id: id});
            $('#saveOcArchivedDatasetFileModal').modal('show');
        };

        $scope.delete = function (id) {
            $scope.ocArchivedDatasetFile = OcArchivedDatasetFile.get({id: id});
            $('#deleteOcArchivedDatasetFileConfirmation').modal('show');
        };

        $scope.confirmDelete = function (id) {
            OcArchivedDatasetFile.delete({id: id},
                function () {
                    $scope.loadAll();
                    $('#deleteOcArchivedDatasetFileConfirmation').modal('hide');
                    $scope.clear();
                });
        };

        $scope.clear = function () {
            $scope.ocArchivedDatasetFile = {name: null, id: null};
        };
    });
