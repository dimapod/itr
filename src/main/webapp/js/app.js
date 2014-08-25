'use strict';

angular.module('itrade', [
    'ui.router',
    'notifications',
    'ecom.exceptionHandler',
    'ecom.httpRequestTracker'
])

    .config(function ($stateProvider, $urlRouterProvider) {

        $urlRouterProvider.otherwise("/entities");
        $stateProvider
            .state('entities', {
                url: "/entities",
                templateUrl: "js/entities/entities.tpl.html"
            });

    });



