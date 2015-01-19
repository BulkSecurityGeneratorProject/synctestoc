'use strict';

angular.module('openclinicaApp')
    .controller('LogoutController', function (Auth) {
        Auth.logout();
    });
