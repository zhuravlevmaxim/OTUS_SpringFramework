$(document).ready(function() {
    $("#getAuthors").click(function (event) {
        event.preventDefault();
        getAuthors();
    });
    function getAuthors(){
        $.ajax({
            type : "POST",
            contentType : "application/json",
            url : "/authors",
            data : "",
            dataType : "json",
            success : function(result) {
                createTableAuthors(result);
                console.log("success table authors!");
            },
            error : function(e) {
                console.log("ERROR: ", e);
            }
        });
    }
})