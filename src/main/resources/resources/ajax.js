/**
 * Created by rporeba on 18.08.2016.
 */

$(document).ready(function() {

    $('#form').submit(function(event) {

        var firstName = $('#firstName').val();
        var lastName = $('#lastName').val();
        var json = { "firstName" : firstName, "lastName": lastName};

        $.ajax({
            type: "POST",
            url: $("#form").attr( "action"),
            contentType : 'application/json; charset=utf-8',
            data: JSON.stringify(json),
            async: true,

            beforeSend: function(xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
            },

            success: function(response) {

                if(response.status == "SUCCESS"){

                    var respContent = "";

                    respContent += "Borrower [";
                    respContent += firstName + " " ;
                    respContent += lastName + "] has been created successfully. You can go back..."

                    $("#borrowerFromResponse").html(respContent);

                } else{

                    var respContent = "";

                    for(i =0 ; i < response.result.length ; i++){
                        respContent += "<br>" + response.result[i].code;
                    }

                    $("#borrowerFromResponse").html(respContent);

                }
            },

            error: function () {
                alert('Error while request from...');
            }

        });

        event.preventDefault();
    });

});
