angular.module('campus-front').controller('createStudentController', function ($scope, $http, $location) {
    const contextPath = 'http://localhost:8189/campus_1/';

    $scope.createStudent = function () {
        if ($scope.new_student == null) {
            alert('Форма не заполнена');
            return;
        }
        $http.post(contextPath + 'api/v1/students', $scope.new_student)
            .then(function successCallback(response) {
                $scope.new_student = null;
                alert('Студент успешно создан');
                $location.path('/campus');
            }, function failureCallback(response) {
                console.log(response);
                alert(response.data.messages);
            });
    }
});