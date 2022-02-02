angular.module('campus-front').controller('editStudentController', function ($scope, $http, $routeParams, $location) {
    const contextPath = 'http://localhost:8189/campus_1/';

    $scope.prepareStudentForUpdate = function () {
        $http.get(contextPath + 'api/v1/students/' + $routeParams.studentId)
            .then(function successCallback(response) {
                $scope.updated_student = response.data;
            }, function failureCallback(response) {
                console.log(response);
                alert(response.data.messages);
                $location.path('/campus');
            });
    }

    $scope.updateStudent = function () {
        $http.put(contextPath + 'api/v1/students', $scope.updated_student)
            .then(function successCallback(response) {
                $scope.updated_student = null;
                alert('Студент успешно обновлен');
                $location.path('/campus');
            }, function failureCallback(response) {
                alert(response.data.messages);
            });
    }

    $scope.prepareStudentForUpdate();
});