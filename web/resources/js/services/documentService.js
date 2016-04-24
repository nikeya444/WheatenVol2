'use strict';

App.factory('DocumentService', ['$http', '$q', function($http, $q) {

    return {
        fetchCurrentMonthDocuments: function() {
            return $http.get('http://localhost:8080/documents')
                .then(
                    function(response) {
                        return response.data;
                    },
                    function(errResponse) {
                        console.error('Error while fetching current documents');
                        return $q.reject(errResponse);
                    }
            )
        },
        fetchOrders: function() {
            return $http.get('http://localhost:8080/documents?status=0')
                .then(
                    function(response) {
                        return response.data;
                    },
                    function(errResponse) {
                        console.error('Error while fetching orders');
                        return $q.reject(errResponse);
                    }
            )
        },
        getTypes: function() {
            return $http.get('http://localhost:8080/documents/types')
                .then(
                    function(response) {
                        return response.data;
                    },
                    function(errResponse) {
                        console.error('Error while fetching orders');
                        return $q.reject(errResponse);
                    }
            )
        }

    }

}])