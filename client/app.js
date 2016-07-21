/**
 * Created by Chetas on 6/18/2016.
 */

/* plunker is a main module of this project MovieFlix. UI-router has been used so that we dont need to refrrsh the whole page when user requires action on particular
part of the code. UI-router provides flexibility to the application as well as enables nested view.
 *  */

var app = angular.module('plunker', ['ngAnimate', 'ui.bootstrap', 'ui.router']);

app.config(function($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise('/Main');

    $stateProvider
        .state('main', {
            url: '/Main',
            views:{
                '@':{
                    templateUrl: './main.html',
                    controller: 'RecipeController'
                }
            }

        })
       .state('home', {
            url: '/Home',
          views:{
              '@':{
                  templateUrl: './Home.html',
                  controller: 'RecipeController'
              }
          }
              
        })
        .state('signup', {
            url: '/Signup',
            views:{
                '@':{
                    templateUrl: './signup.html',
                    controller: 'RecipeController'
                }
            }
        })
        .state('signin', {
            url: '/Signin',
            views:{
                '@':{
                    templateUrl: './signin.html',
                    controller: 'RecipeController'
                }
            }
        })
        .state('contact', {
            url: '/Contact',
            views:{
                '@':{
                    templateUrl: './contact.html',
                    controller: 'RecipeController'
                }
            }
        })
    
});