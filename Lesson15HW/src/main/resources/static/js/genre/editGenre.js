$(document).ready(function() {
    $("#editGenreForm").submit(function (event) {
        event.preventDefault();
        editGenre();
    });
    function editGenre(){
        var formData = {
            id : $("#id").val(),
            genre :  $("#genre").val()
        }
        $.ajax({
            type : "PUT",
            contentType : "application/json",
            url : "/editGenre",
            data : JSON.stringify(formData),
            dataType : "json",
            success : function(result) {
                //createTableGenres(result);
                console.log("success edit genre!");
            },
            error : function(e) {
                console.log("ERROR: ", e);
            }
        });
    }
})