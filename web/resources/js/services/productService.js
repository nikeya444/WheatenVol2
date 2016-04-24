'use strict';

App.factory('ProductService', ['$http', '$q', function($http, $q) {

    return {
        fetchAll: function() {
            return $http.get('http://localhost:8080/products')
                .then(
                function(response) {
                    return response.data;
                },
                function(errResponse) {
                    console.error('Error while fetching products');
                    return $q.reject(errResponse);
                }
            )
        },
        fetchOne: function(id) {
            return $http.get('http://localhost:8080/products/' + id)
                .then(
                function(response) {
                    return response.data;
                },
                function(errResponse) {
                    console.error('Error while fetching product');
                    return $q.reject(errResponse);
                }
            )
        }
    }

}])