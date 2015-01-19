'use strict';

angular.module('openclinicaApp')
    .factory('Register', function ($resource) {
        return $resource('api/register', {}, {
        });
    });


