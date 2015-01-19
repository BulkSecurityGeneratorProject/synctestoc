'use strict';

angular.module('openclinicaApp')
    .controller('OcUserController', function ($scope, OcUser) {
        $scope.ocUsers = [];
        $scope.loadAll = function() {
            OcUser.query(function(result) {
               $scope.ocUsers = result;
            });
        };
        $scope.loadAll();

        $scope.create = function () {
            OcUser.save($scope.ocUser,
                function () {
                    $scope.loadAll();
                    $('#saveOcUserModal').modal('hide');
                    $scope.clear();
                });
        };

        $scope.update = function (id) {
            $scope.ocUser = OcUser.get({id: id});
            $('#saveOcUserModal').modal('show');
        };

        $scope.delete = function (id) {
            $scope.ocUser = OcUser.get({id: id});
            $('#deleteOcUserConfirmation').modal('show');
        };

        $scope.confirmDelete = function (id) {
            OcUser.delete({id: id},
                function () {
                    $scope.loadAll();
                    $('#deleteOcUserConfirmation').modal('hide');
                    $scope.clear();
                });
        };

        $scope.clear = function () {
            $scope.ocUser = {login: null, password: null, id: null};
        };
    });
