var myApp = angular.module('myApp');

myApp.controller('HomeController', [ '$scope', '$http', function ($scope, $http) {
	$scope.hello = 'Im Home';
}]);


myApp.controller('DenemeController', [ '$scope', '$http',  function($scope) {
	 $scope.test = function() {
		 alert('controller2 : ' + $scope.name);
	 };
});


myApp.controller('BeverageController', [ '$scope', '$http', function ($scope, $http) {
	$http.get('beverage/list').success(function(data) {
		$scope.beverages = data;
	}).error(function(data) {
		alert('error');
	});
	
	$scope.saveBeverage:function (beverage) {
			alert(beverage)
			console.log(beverage);
	}
}]);


myApp.controller('BlendController', [ '$scope', '$http', function ($scope, $http) {
	$http.get('blend/list')
	.success(function(data){
		$scope.blends = data;
	})
	.error(function(data){
		alert('error');
	});
	
}]);


app.controller('OrderController', function($scope, customerService) {
    callToAddToBeverageList = function(beverage){
        customerService.addCustomer(beverage);
    };
});
	
}]);
	
