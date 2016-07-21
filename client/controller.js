/**
 * Created by Chetas on 7/01/2016.
 */

/*This is main controller file. contains three controllers. First controller is main controller and other two are for modal view.
* RecipeController: This controller gets movies and users data from database and provides authentication to signin and for signup, it sends data
* to the database. It also has a function sortBy. This function uses property value and pass it to the filter to get the detail sorted.
* This implements sorting functionality of this Application.
* ModalDemoCtrl and ModalInstanceCtrl are for Modal view. One is calling other here. One implements ok and cancel button.*/

var app = angular
    .module('plunker');

app.controller('RecipeController', ['$http','$scope','$location', function ($http, $scope, $location) {
            $scope.list1='';
            $http.get('http://localhost:8080/app/api/movies').success(function (response) {
                  $scope.list = response;
                });

            $http.get('http://localhost:8080/app/api/users').success(function (response) {
            $scope.list1 = response;
                });

            $scope.login = function(){
                var flag=0;
                for(i=0;i<$scope.list1.length;i++)
                {

                    $http.get('http://localhost:8080/app/api/users').success(function (response) {
                        $scope.list1 = response;
                    });

                    if (this.formData.email == $scope.list1[i].email && this.formData.password == $scope.list1[i].password ) {
                        $scope.name = this.formData.email;
                        $location.url("/Home");
                        flag=1;
                        break;
                    }
                }
                if(flag==0)
                    console.log("Wrong Password");
            };
            $scope.propertyName = '';
            $scope.reverse = true;
            $scope.sortBy = function(propertyName) {
            $scope.reverse = ($scope.propertyName === propertyName) ? !$scope.reverse : false;
            $scope.propertyName = propertyName;
                };
            $scope.formData = {};


            $scope.formSubmit = function() {
                 console.log(this.formData.email);
                this.formData.type="user";
                console.log(this.formData);
                    $http.post('http://localhost:8080/app/api/users', angular.toJson(this.formData)).success(function (response) {
                        console.log("Success");
                        window.location.reload();
                        
                    })
                };
}]);

app.controller('ModalDemoCtrl', function ($scope, $uibModal) {

    $scope.item;

    $scope.animationsEnabled = true;

    $scope.open = function (size) {
        console.log(size);
        console.log(typeof(size));
        var modalInstance = $uibModal.open({
            animation: $scope.animationsEnabled,
            templateUrl: 'myModalContent.html',
            controller: 'ModalInstanceCtrl',
            resolve: {
                item: function () {
                    return size;
                }
            }
        });
    };

    $scope.toggleAnimation = function () {
        $scope.animationsEnabled = !$scope.animationsEnabled;
    };

});

app.controller('ModalInstanceCtrl', function ($scope, $uibModalInstance, item) {

    $scope.item = item;

    $scope.ok = function () {
        $uibModalInstance.dismiss('ok');
    };

    $scope.cancel = function () {
        $uibModalInstance.dismiss('cancel');
    };
});


app.controller('RatingDemoCtrl', function ($scope) {
    $scope.rate = 7;
    $scope.max = 10;
    $scope.isReadonly = false;

    $scope.hoveringOver = function(value) {
        $scope.overStar = value;
        $scope.percent = 100 * (value / $scope.max);
    };

    $scope.ratingStates = [
        {stateOn: 'glyphicon-ok-sign', stateOff: 'glyphicon-ok-circle'},
        {stateOn: 'glyphicon-star', stateOff: 'glyphicon-star-empty'},
        {stateOn: 'glyphicon-heart', stateOff: 'glyphicon-ban-circle'},
        {stateOn: 'glyphicon-heart'},
        {stateOff: 'glyphicon-off'}
    ];
});

