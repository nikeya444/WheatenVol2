import typeahead from '/resources/js/src/typeahead';


var App = angular.module('wheatenApp', ['ui.router', typeahead]);

App.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise("/documents");

    $stateProvider
        .state('documents', {
            url: "/documents",
            templateUrl: "document",
            controller: "DocumentController as docCtrl",
            resolve: {
                asyncDocuments: ['DocumentService', function(DocumentService) {
                    return DocumentService.fetchCurrentMonthDocuments();
                }],
                asyncProducts: ['ProductService', function(ProductService) {
                    return ProductService.fetchAll();
                }],
                asyncPartners: ['PartnerService', function(PartnerService) {
                    return PartnerService.fetchAll();
                }],
                asyncStorages: ['StorageService', function(StorageService) {
                    return StorageService.fetchAll();
                }],
                types: ['DocumentService', function(DocumentService) {
                    return DocumentService.getTypes();
                }]
            }
        })
        .state('orders', {
            url: "/documents/orders",
            templateUrl: "document",
            controller: "DocumentController as docCtrl",
            resolve: {
                async: ['DocumentService', function(DocumentService) {
                    return DocumentService.fetchOrders();
                }]
            }
        })
}

]);