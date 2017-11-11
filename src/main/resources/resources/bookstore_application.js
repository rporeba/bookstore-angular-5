/**
 * Created by rporeba on 29.08.2016.
 */

var bookstore = angular.module('bookstore', ["ngResource", "ngRoute", "ui.bootstrap", "ui.router", "pascalprecht.translate", "ngMessages"]).run(function ($rootScope) {

    // adds some basic utilities to the $rootScope for debugging purposes
    $rootScope.log = function (thing) {
        console.log(thing);
    };

    $rootScope.alert = function (thing) {
        alert(thing);
    };

})
