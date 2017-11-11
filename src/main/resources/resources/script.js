/**
 * Created by rporeba on 18.08.2016.
 */

// Waiting until DOM is ready
$(document).ready(function () {

    var selectedBookId = null;

    $(".selectedBook").change(function () {

        selectedBookId = $(this).val();

        $("#editbook").prop("disabled", false);
        $("#deletebook").prop("disabled", false);
        $("#bookdetails").prop("disabled", false);

    });

    $("#editbook").click(function () {

        window.location = "/bookstore/editbook/" + selectedBookId;
    });

    $("#deletebook").click(function () {

        $( function() {
           $( "#dialog" ).dialog({
                resizable: false,
                height: "auto",
                width: 400,
                modal: true,
                show: "blind",
                hide: "explode",
                buttons: {
                    "Delete": function() {

                        $( this ).dialog( "close" );
                        $.post("/bookstore/deletebook/",
                            {itemId: selectedBookId},
                            function () {
                                location.reload();
                            });

                    },
                    "Cancel": function() {
                        $( this ).dialog( "close" );
                    }
                }
            })
        } );

/*        $.post('/bookstore/delete/', {
            itemId : selectedBookId
        }, function() {
            location.reload();
        });*/

    });

    $("#bookdetails").click(function () {

        window.location = "/bookstore/bookdetails/" + selectedBookId;
    });

    //------------------------------------------------------------------------------------------------------------------

    // datepicker
    $(function () {

        $(function () {
            $("#published").datepicker({
                changeMonth: true,
                changeYear: true,
                dateFormat: "mm-dd-yy",
            });
        });
    });

    //tabs
    //------------------------------------------------------------------------------------------------------------------

    $(function () {
        $(function () {
            $("#tabs").tabs();
        });
    });

    //tooltip
    //------------------------------------------------------------------------------------------------------------------

    $(function () {
        $(function () {
            $(document).tooltip();
        });
    });

    //------------------------------------------------------------------------------------------------------------------


});
