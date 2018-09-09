$(document).ready(function() {
    $("#getBooks").click(function (event) {
        event.preventDefault();
        getBooks();
    });
    function getBooks(){
        $.ajax({
            type : "POST",
            contentType : "application/json",
            url : "/books",
            data : "",
            dataType : "json",
            success : function(result) {
                createTableBooks(result);
                console.log("success table books!");
            },
            error : function(e) {
                console.log("ERROR: ", e);
            }
        });
    }
})