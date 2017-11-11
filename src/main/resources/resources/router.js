/**
 * Created by rporeba on 30.08.2016.
 */

bookstore.config(function ($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise("/books");

    $stateProvider
        .state("search", {
            url: "/search",
            templateUrl: "search.ftl",
            controller: "BookController"
        })
        .state("details", {
            url: "/details/:bookId",
            templateUrl: "details.html",
            controller: "DetailsController",
            resolve: {
                bookId: ["$stateParams", function ($stateParams) {
                    return $stateParams.bookId;
                }]
            }
        })

});