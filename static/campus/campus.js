angular.module('campus-front').controller('campusController', function ($scope, $http, $location) {
    const contextPath = 'http://localhost:8189/campus_1/';
    let currentPageIndex = 1;

    $scope.loadStudents = function (pageIndex = 1) {
        currentPageIndex = pageIndex;
        $http({
            url: contextPath + 'api/v1/students',
            method: 'GET',
            params: {
                p: pageIndex
            }
        }).then(function (response) {
            console.log(response);
            $scope.studentsPage = response.data;
            $scope.paginationArray = $scope.generatePagesIndexes(1, $scope.studentsPage.totalPages);
        });
    };

    $scope.generatePagesIndexes = function (startPage, endPage) {
        let arr = [];
        for (let i = startPage; i < endPage + 1; i++) {
            arr.push(i);
        }
        return arr;
    }

    $scope.navToEditStudentPage = function (student_Id) {
        $location.path('/edit_student/' + student_Id);
    }


    $scope.deleteStudent = function (student) {
        $http({
            // url: contextPath + 'api/v1/products/delete/' + product.id,
            url: contextPath + 'api/v1/students/' + student.id,
            method: 'DELETE',
        }).then(function (response) {
            console.log(response);
            $scope.studentsPage = response.data;
            $scope.loadStudents();
        });
    };


    $scope.loadStudents();
});