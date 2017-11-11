<#include "macro/borrowList.ftl"/>
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

<script>

    $(document).ready(function () {
        var selectedBorrowId = null;

        $(".selectedBorrow").change(function () {

            selectedBorrowId = $(this).val();

            $("#givebookback").prop("disabled", false);


        });

        $("#givebookback").click(function () {

            $(function () {

                $.post("/bookstore/returnBook",
                        {id: selectedBorrowId},
                        function () {
                            location.reload();
                        });

            });
        });

    });

</script>

    <@borrowList borrows = command.borrowList />


<div class="nav">

    <a href="/bookstore/books" class="btn btn-success" role="button">Back</a>
    <button id="givebookback" class="btn btn-danger" type="submit" disabled>Give book back</button>
    <div id="dialog" title="Dou you want to give back selected book?">
    </div>

</div>

</@layout.masterPage>
