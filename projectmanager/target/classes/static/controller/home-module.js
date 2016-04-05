(function() {
  'use strict';

  var module = angular
    .module('projectManagerApp', ['ngAnimate', 'ngCookies', 'ngTouch', 'ngSanitize', 'ngMessages', 'ngAria', 'ngResource', 'ngRoute', 'ngMaterial', 'toastr']);

  module
    .config(routeConfig);

  function routeConfig($routeProvider, $urlRouterProvider) {
	  //Definição de rotas
	  $routeProvider
	  .when('/', {
	    templateUrl: 'ui/index.html',
	    controller: 'MainController',
	    controllerAs: 'main'
	  })
	  .when('/project/:id', {
	    templateUrl: 'app/project/project.html',
	    controller: 'ProjectController',
	    controllerAs: 'project'
	  })
	  .otherwise({ //Caso ocorra uma tentativa de rota não existente redicionará para a principal.
	    redirectTo: '/'
	  });
  }

})();
