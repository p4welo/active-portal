angular.module('activePortal.customers')

    .config(function config( $stateProvider ) {
        $stateProvider.state('customerBase', {
            url: '/customerBase',
            controller: 'customerBaseCtrl',
            templateUrl: 'customers/base/customerBase.tpl.html'
        });
    })

    .controller('customerBaseCtrl', function ($scope) {

    })
;