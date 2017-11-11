<#import "defaultLayout.ftl" as layout>
<#import "spring.ftl" as spring />

<style>

    #accessDenied {
        text-align: center;
    }

</style>

<@layout.masterPage>

<div id="accessDenied">

    <div>
        <h2>
            <p>Access denied, You are not authorized to access this page!</p>
            <p>You can go back or Log out.</p>
        </h2>
    </div>

    <div>
        <a href="/bookstore/books" class="btn btn-success custom-width" role="button">Go Back</a>
    </div>

</div>

</@layout.masterPage>


