$(document).ready(function() {
    $("#getGenres").click(function (event) {
        event.preventDefault();
        getGenres();
    });
    function getGenres(){
        $.ajax({
            type : "POST",
            contentType : "application/json",
            url : "/genres",
            data : "",
            dataType : "json",
            success : function(result) {
                createTableGenres(result);
                console.log("success table genres!");
            },
            error : function(e) {
                console.log("ERROR: ", e);
            }
        });
    }
})