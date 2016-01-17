var myApp = angular.module('myApp',['ui.router']);


myApp.service('orderService', function() {
	  var order = {};
	 
	  addBeverage = function(beverage) {
		  order.beverageDtoList.push(beverage);
	  },
	  getOrder = function(){
	      return order;
	  }
	});

myApp.config(function($stateProvider, $urlRouterProvider) {

	$urlRouterProvider.when('', '/home');
	$urlRouterProvider.otherwise('/home');

	$stateProvider.state('home', {
		url : '/home',
		templateUrl : 'views/home.html',
		controller : 'HomeController'
	}).state('beverages', {
		url : '/beverages',
		templateUrl : 'views/beverages.html',
		controller : 'BeverageController'
	}).state('blends', {
		url : '/blends',
		templateUrl : 'views/blends.html',
		controller : 'BlendController'
	}).state('orders', {
		url : '/orders',
		templateUrl : 'views/orders.html',
		controller : 'OrderController'
	})
});


myApp.run([
		'$rootScope',
		'$location',
		function($rootScope, $location) {

			$rootScope.$on('$stateChangeStart', function(evt, toState,
					toParams, fromState, fromParams) {
				$rootScope.currentNavLink = $location.path();
			});

		} ]);

