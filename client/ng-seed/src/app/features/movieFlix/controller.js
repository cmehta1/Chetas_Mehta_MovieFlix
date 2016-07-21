/**
 * Created by Chetas on 7/14/2016.
 */

var app = angular
    .module('plunker');

app.controller('RecipeController', ['$scope','$http', function ($scope, $http) {
            $http.get('movielist.json').success(function (response) {
                  $scope.list = response;
                })
            $scope.propertyName = '';
            $scope.reverse = true;
            $scope.sortBy = function(propertyName) {
            $scope.reverse = ($scope.propertyName === propertyName) ? !$scope.reverse : false;
            $scope.propertyName = propertyName;


                $scope.go_back = function() {
                    $window.location.href = 'Home.html';
                };

        };
   //      $scope.totalItems=20;
   //      $scope.currentPage=1;
   //      $scope.setPage = function (pageNo)
   //      {
   //          $scope.currentPage = pageNo;
   //      };
   //      $scope.pageChanged = function() {
   //          console.log('Page changed to: ' + $scope.currentPage);
   // };


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