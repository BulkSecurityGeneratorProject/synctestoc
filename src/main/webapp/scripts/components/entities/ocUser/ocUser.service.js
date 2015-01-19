'use strict';

angular.module('openclinicaApp')
    .factory('OcUser', function ($resource) {
        return $resource('api/ocUsers/:id', {}, {
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
