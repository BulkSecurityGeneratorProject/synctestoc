'use strict';

angular.module('openclinicaApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('ocArchivedDatasetFile', {
                parent: 'entity',
                url: '/ocArchivedDatasetFile',
                data: {
                    roles: ['ROLE_USER']
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/ocArchivedDatasetFile/ocArchivedDatasetFiles.html',
                        controller: 'OcArchivedDatasetFileController'
                    }
                },
                resolve: {
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('ocArchivedDatasetFile');
                        return $translate.refresh();
                    }]
                }
            })
            .state('ocArchivedDatasetFileDetail', {
                parent: 'entity',
                url: '/ocArchivedDatasetFile/:id',
                data: {
                    roles: ['ROLE_USER']
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/ocArchivedDatasetFile/ocArchivedDatasetFile-detail.html',
                        controller: 'OcArchivedDatasetFileDetailController'
                    }
                },
                resolve: {
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('ocArchivedDatasetFile');
                        return $translate.refresh();
                    }]
                }
            });
    });
