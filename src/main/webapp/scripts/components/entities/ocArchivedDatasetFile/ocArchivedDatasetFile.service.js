'use strict';

angular.module('openclinicaApp')
    .factory('OcArchivedDatasetFile', function ($resource) {
        return $resource('api/ocArchivedDatasetFiles/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    data = angular.fromJson(data);
                    return data;
                }
            }
        });
    });
