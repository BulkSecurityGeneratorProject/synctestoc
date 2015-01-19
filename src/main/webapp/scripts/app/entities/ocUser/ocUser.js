'use strict';

angular.module('openclinicaApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('ocUser', {
                parent: 'entity',
                url: '/ocUser',
                data: {
                    roles: ['ROLE_USER']
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/ocUser/ocUsers.html',
                        controller: 'OcUserController'
                    }
                },
                resolve: {
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('ocUser');
                        return $translate.refresh();
                    }]
                }
            })
            .state('ocUserDetail', {
                parent: 'entity',
                url: '/ocUser/:id',
                data: {
                    roles: ['ROLE_USER']
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/ocUser/ocUser-detail.html',
                        controller: 'OcUserDetailController'
                    }
                },
                resolve: {
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('ocUser');
                        return $translate.refresh();
                    }]
                }
            });
    });
