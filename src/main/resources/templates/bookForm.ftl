<#import "defaultLayout.ftl" as layout>
<#import "spring.ftl" as spring />
<#include "macro/formMacro.ftl"/>

<style>

    #form {
        position: relative;
        margin: 0 auto;
        width: 50%;
        /*margin-left: 20px;*/
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

<form id="form" class="form-horizontal" action="/bookstore/savebook" method="post">

    <div id="header">
        <h2>Book form</h2>
    </div>

    <@inputText path="command.bookDto.itemId" attributes="" title="We ask you to insert the book ID (optionaly)" name="itemId" type="hidden" />

    <@label messageKey="command.bookDto.bookTitle" id="bookTitle">
        <@inputText path="command.bookDto.bookTitle" attributes=""  title="We ask you to insert the title of book"  name="bookTitle" id="bookTitle" type="text"  />
    </@label>

    <@label messageKey="command.bookDto.isbn" id="isbn">
        <@inputText path="command.bookDto.isbn" attributes="" title="We ask you to insert the ISBN number" name="isbn" id="isbn" type="text"  />
    </@label>

    <@label messageKey="command.bookDto.numberOfPage" id="numberOfPage">
        <@inputText path="command.bookDto.numberOfPage" attributes=""  title="We ask you to insert number of book page" name="numberOfPage" id="numberOfPage" type="text" />
    </@label>

    <@label messageKey="command.bookDto.published" id="published">
        <@inputText path="command.bookDto.published" attributes="" title="We ask you to choose date when the book has been released" name="published" id="published"  type="text" id="published" />
    </@label>

    <@label messageKey="command.bookDto.typeOfBook" id="typeOfBook">
        <@spring.formSingleSelect path="command.bookDto.typeOfBook" options=command.enumMap attributes="class='form-control'" />
    </@label>

    <@label messageKey="command.bookDto.authorDto.firstName" id="firstName">
        <@inputText path="command.bookDto.authorDto.firstName" attributes=""  title="We ask for your First Name" name="firstName" id="firstName" type="text"/>
    </@label>

    <@label messageKey="command.bookDto.authorDto.lastName" id="lastName">
        <@inputText path="command.bookDto.authorDto.lastName" attributes=""  title="We ask for your Last Name" name="lastName" id="lastName" type="text"/>
    </@label>

    <div id="buttons">
        <button class="btn btn-primary" type="submit">Submit form</button>
        <a href="/bookstore/books" class="btn btn-success custom-width" role="button">Back</a>
    </div>

</form>

</@layout.masterPage>


