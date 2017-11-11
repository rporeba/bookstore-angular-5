<#import "defaultLayout.ftl" as layout>
<#import "spring.ftl" as spring />
<#include "macro/formMacro.ftl"/>
<#include "macro/borrowerList.ftl"/>

<style>
    .form-horizontal {
        position: relative;
        /*       margin: 0 auto;*/
        width: 50%;
        margin-left: 20px;
        margin-top: 20px;
        margin-bottom: 20px;
        padding: 20px;
        background-color: #E8E1E1;
        border: 1px solid #ddd;
        border-radius: 4px;
    }

    #buttons {
        position: relative;
        margin: 0 auto;
        width: 50%;
        margin-top: 20px;
        padding: 20px;
    }

    #header {
        text-align: center;
    }
</style>

<@layout.masterPage>

<table id="book" class="table table-striped">
    <form class="form-horizontal" action="/bookstore/borrow" method="post">

        <div id="header">
            <h2>Book Details</h2>
        </div>

        <input type="hidden" name="itemId" value="${command.bookDto.itemId}">

        <@displayFiled field=command.bookDto.itemId attributes="" messageKey="command.bookDto.itemId"/>

        <@displayFiled field=command.bookDto.isbn attributes="" messageKey="command.bookDto.isbn"/>

        <@displayFiled field=command.bookDto.bookTitle attributes="" messageKey="command.bookDto.bookTitle"/>

        <@displayFiled field=command.bookDto.numberOfPage attributes="" messageKey="command.bookDto.numberOfPage"/>

        <@displayFiled field=command.bookDto.published attributes="" messageKey="command.bookDto.published"/>

        <@displayFiled field=command.bookDto.typeOfBook attributes="" messageKey="command.bookDto.typeOfBook"/>

        <@displayFiled field=command.bookDto.authorDto.lastName attributes="" messageKey="command.bookDto.authorDto.lastName"/>

        <@displayFiled field=command.bookDto.authorDto.firstName attributes="" messageKey="command.bookDto.authorDto.firstName"/>

        <@borrowerList borrowers = command.borrowerList messageKey="command.bookDto.borrowerDto.lastName" />

<#--       <@displayFiled field=command.bookDto.borrowerDto.lastName attributes="" messageKey="command.bookDto.borrowerDto.lastName"/>-->

        <div id="buttons">
            <div class="nav">
                <button class="btn btn-primary" type="submit">Borrow Book</button>
                <a href="/bookstore/books" class="btn btn-success custom-width" role="button">Back</a>
            </div>
        </div>

    </form>
</table>
</@layout.masterPage>







