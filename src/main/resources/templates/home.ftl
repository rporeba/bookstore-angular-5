<#include "macro/bookList.ftl"/>
<#import "defaultLayout.ftl" as layout>

<style>

    .nav {
        margin-top: 10px;
    }

    #search {
        text-align: left;
    }

</style>

<@layout.masterPage>

    <@bookList books = command.bookList />

<div class="nav">
    <a href="/bookstore/newbook" class="btn btn-primary" role="button">New book</a>
    <button id="deletebook" class="btn btn-danger" type="submit" disabled>Delete</button>
    <button id="editbook" class="btn btn-success custom-width" disabled>Edit</button>
    <button id="bookdetails" class="btn btn-info" disabled>Show Details</button>
    <a href="/bookstore/borrows" class="btn btn-primary" role="button">Borrows</a>
    <a href="/bookstore/newborrower" class="btn btn-success" role="button">New Borrower</a>
    <a href="/bookstore/search" id="search" class="btn-info btn pull-right" role="button">Search book</a>

    <div id="dialog" title="Dou you want to delete selected book?">
    </div>
</div>

</@layout.masterPage>
