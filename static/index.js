(function () {
    angular
        .module('campus-front', ['ngRoute', 'ngStorage'])
        .config(config);
//        .run(run);

    function config($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'welcome/welcome.html',
                controller: 'welcomeController'
            })
            .when('/campus', {
                templateUrl: 'campus/campus.html',
                controller: 'campusController'
            })
            .when('/edit_student/:studentId', {
                templateUrl: 'edit_student/edit_student.html',
                controller: 'editStudentController'
            })
            .when('/create_student', {
                templateUrl: 'create_student/create_student.html',
                controller: 'createStudentController'
            })
            .otherwise({
                redirectTo: '/'
            });
    }
})();

angular.module('campus-front').controller('indexController', function ($rootScope, $scope, $http, $localStorage) {
    const contextPath = 'http://localhost:8189/campus_1';

});