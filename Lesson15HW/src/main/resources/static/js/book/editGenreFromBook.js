$(document).ready(function() {
    $("#editGenreBookForm").submit(function (event) {
        event.preventDefault();
        console.log($("#genre-input"));
        editGenreBookPost();
    });
    function editGenreBookPost(){
        $.ajax({
            type : "POST",
            contentType : "application/text",
            url : "editGenreBook?id=" + $("#id").val(),
            data : $("#genre-input").val(),
            dataType : "text",
            success : function(result) {
                console.log("success edit genre!");
            },
            error : function(e) {
                console.log("ERROR: ", e);
            }
        });
    }
})