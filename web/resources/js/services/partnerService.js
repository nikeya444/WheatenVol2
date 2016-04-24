'use strict';

App.factory('PartnerService', ['$http', '$q', function($http, $q) {

    return {
        fetchAll: function() {
            return $http.get('http://localhost:8080/partners')
                .then(
                function(response) {
                    return response.data;
                },
                function(errResponse) {
                    console.error('Error while fetching partners');
                    return $q.reject(errResponse);
                }
            )
        },
        fetchOne: function(id) {
            return $http.get('http://localhost:8080/partners/' + id)
                .then(
                function(response) {
                    return response.data;
                },
                function(errResponse) {
                    console.error('Error while fetching partner');
                    return $q.reject(errResponse);
                }
            )
        },
        fetchLike: function(name) {
            return $http.get('http://localhost:8080/partners?fullname=' + name)
                .then(
                function(response) {
                    return response.data;
                },
                function(errResponse) {
                    console.error('Error while fetching partner like ' + name);
                    return $q.reject(errResponse);
                }
            )
        }
    }

}])