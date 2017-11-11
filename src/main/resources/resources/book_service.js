/**
 * Created by rporeba on 29.08.2016.
 */

bookstore.factory("BookService", function ($q, $http, $log, BookResource) {

    getColumns = function () {
        return $http.get("/columns").then(function (response) {
            return response.data;
        });
    };

    getBooks = function () {
        return BookResource.query();
    };

    getBookById = function (id) {
        return BookResource.get({id: id});
    };

    deleteBook = function (id) {
        BookResource.delete({id: id});
    };

    addBook = function (book) {
        BookResource.save(book);
    };

    editBook = function (book) {
        BookResource.update(book);
    };


    return {
        getBooks: getBooks,
        getColumns: getColumns,
        getBookById: getBookById,
        deleteBook: deleteBook,
        addBook: addBook,
        editBook: editBook,
    };
});

