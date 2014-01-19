 /* MINIFIER: OFF */ 

function UsersListController($scope, $http) {
    $scope.users = [];
    console.log("call api");
    $http.get('/delegate/services/users')
        .success(function(data) {
            $scope.users = data;
            console.log(data);
        });
 
}