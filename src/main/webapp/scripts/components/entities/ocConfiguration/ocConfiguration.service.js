'use strict';

angular.module('openclinicaApp')
    .factory('OcConfiguration', function ($resource) {
        return $resource('api/ocConfigurations/:id', {}, {
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
