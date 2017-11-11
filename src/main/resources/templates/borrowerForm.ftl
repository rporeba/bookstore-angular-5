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
</style>

<@layout.masterPage>

<script>
    $(function () {
        $("#tabs").tabs();
    });
</script>

<div>
    <h4>Here you can create new Borrower. AJAX example with validation from server side</h4>
</div>

<form id="form" class="form-horizontal" action="/bookstore/newborrower.json" method="POST">

    <div id="tabs-borrower">

        <h5>
            <div id="borrowerFromResponse"></div>
        </h5>

        <@label messageKey="command.borrowerDto.firstName" id="firstName">
            <@inputText path="command.borrowerDto.firstName" attributes="" title="We ask you to insert the firstName" name="firstName" type="text" id="firstName" />
        </@label>

        <@label messageKey="command.borrowerDto.lastName" id="lastName">
            <@inputText path="command.borrowerDto.lastName" attributes="" title="We ask you to insert the lastName" name="lastName" type="text" id="lastName" />
        </@label>

        <img style="margin: 1px;">

        <div id="buttons">
            <div class="nav">
                <button class="btn btn-primary" type="submit">Save Borrower</button>
                <a href="/bookstore/books" class="btn btn-success custom-width" role="button">Back</a>
            </div>
        </div>

    </div>

</form>

<script type="text/javascript" src="script.js"></script>
<script type="text/javascript" src="ajax.js"></script>
</@layout.masterPage>


