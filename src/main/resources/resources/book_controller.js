/**
 * Created by rporeba on 29.08.2016.
 */


bookstore.controller('HomeController', function ($scope, $translate, $uibModal, $log, $http, BookService, BookResource) {

    $scope.books = BookService.getBooks();

    BookService.getColumns().then(function (response) {

        $scope.columns = response;

    });

    $scope.selectedBook = {};

    $scope.deleteBook = function (selectedBookId) {

        $log.info("Delete book [id = " + selectedBookId + "]");
        BookService.deleteBook(selectedBookId);
        $scope.selectedBook = {};
        $scope.books = BookService.getBooks();

    };

});


