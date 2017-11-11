<#import "defaultLayout.ftl" as layout>
<#import "spring.ftl" as spring />
<#include "macro/bookList.ftl"/>
<#include "macro/formMacro.ftl"/>


<style>

    .nav {
        margin-top: 20px;
    }

    #search {
        text-align: left;
    }

    #header {
        text-align: center;
    }

    #search-form {
        position: relative;
        text-align: center;
        margin-top: 20px;
        margin-bottom: 20px;
        padding: 20px;
        background-color: #E8E1E1;

    }

</style>

<@layout.masterPage>
<a href="/bookstore/books" id="search" class="btn-info btn pull-right" role="button">Go back</a>

<div id="header">
    <h3>Search books</h3>
</div>

<form class="form-inline" id="search-form">

    <div class="form-group">
    <#--        <label for="bookTitle">Book Title</label>-->
        <input type="text" class="form-control" id="bookTitle" placeholder="Book title">
    </div>

    <div class="form-group">
        <input type="text" class="form-control" id="isbn" placeholder="Isbn">
    </div>

    <div class="form-group">
        <input type="text" class="form-control" id="typeOfBook" placeholder="Type of book">
    </div>

    <div class="form-group">
        <input type="text" class="form-control" id="authorLastName" placeholder="Author Last Name">
    </div>

    <div class="nav">
        <button type="submit" id="bth-search" class="btn btn-success">Search book</button>
    </div>

</form>

<div class="table-responsive">
    <table class="table" id="taskTable">
        <thead>
        <tr>
            <th>ID</th>
            <th>Book Title</th>
            <th>ISBN</th>
            <th>Type of Book</th>
            <th>Number of Page</th>
            <th>Published</th>
            <th>Author First Name</th>
            <th>Author Last Name</th>
            <th>Available</th>
        </tr>
        </thead>
        <tbody id="tbody">
        </tbody>
    </table>
</div>


<script>
    jQuery(document).ready(function ($) {

        $("#search-form").submit(function (event) {

            // Disble the search button
            enableSearchButton(false);

            // Prevent the form from submitting via the browser.
            event.preventDefault();

            searchViaAjax();

        });

    });

    function searchViaAjax() {

        var search = new Object();

        search.itemId = $('#itemId').val();
        search.bookTitle = $("#bookTitle").val();
        search.published = $("#published").val();
        search.authorFirstName = $("#authorFirstName").val();
        search.authorLastName = $("#authorLastName").val();


        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/bookstore/search",
            data: JSON.stringify(search),
            dataType: 'json',
            timeout: 100000,
            success: function (data) {
                console.log("SUCCESS: ", data);
                getSearchedBooks(data);
            },
            error: function (e) {
                console.log("ERROR: ", e);
                display(e);
            },
            done: function (e) {
                console.log("DONE");
                enableSearchButton(true);
            }
        });

    }

    function enableSearchButton(flag) {
        $("#btn-search").prop("disabled", flag);
    }

    function getSearchedBooks(data) {

        $('#tbody').html("");

        $.each(data, function (i, bookDto) {

            $("#tbody").append(
                    "<tr>" +
                    "<td>" + bookDto.itemId + "</td>" +
                    "<td>" + bookDto.bookTitle + "</td>" +
                    "<td>" + bookDto.isbn + "</td>" +
                    "<td>" + bookDto.typeOfBook + "</td>" +
                    "<td>" + bookDto.numberOfPage + "</td>" +
                    "<td>" + bookDto.published + "</td>" +
                    "<td>" + bookDto.authorDto.firstName + "</td>" +
                    "<td>" + bookDto.authorDto.lastName + "</td>" +
                    "<td>" + JSON.stringify(bookDto.isBookBorrowed) + "</td>" +
                    "</tr>"
            );


        });
    }

</script>

</@layout.masterPage>


