/**
 * Created by rporeba on 30.08.2016.
 */

bookstore.factory("BookResource", function ($q, $resource) {

    return $resource("/books/:id", {id: "@id"},
        {"update": {method: "PUT", url: "/books"}});

});