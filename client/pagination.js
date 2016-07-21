/**
 * Created by Chetas on 7/15/2016.
 */

app.controller('PaginationDemoCtrl', function ($scope, $log) {
    $scope.totalItems = 20;
    $scope.currentPage = 1;

    $scope.setPage = function (pageNo) {
        $scope.currentPage = pageNo;
    };

    $scope.pageChanged = function() {
        $log.log('Page changed to: ' + $scope.currentPage);
    };

    $scope.maxSize = 1;
    $scope.bigTotalItems = 5;
    $scope.bigCurrentPage = 1;
});