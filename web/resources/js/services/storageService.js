'use strict';

App.factory('StorageService', ['$http', '$q', function($http, $q) {

    return {
        fetchAll: function() {
            return $http.get('http://localhost:8080/storages')
                .then(
                function(response) {
                    return response.data;
                },
                function(errResponse) {
                    console.error('Error while fetching storages');
                    return $q.reject(errResponse);
                }
            )
        },
        fetchOne: function(id) {
            return $http.get('http://localhost:8080/storages/' + id)
                .then(
                function(response) {
                    return response.data;
                },
                function(errResponse) {
                    console.error('Error while fetching storage');
                    return $q.reject(errResponse);
                }
            )
        }
    }

}])