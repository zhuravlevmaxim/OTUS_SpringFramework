$(document).ready(function() {
    $("#addGenre").submit(function (event) {
        event.preventDefault();
        addGenre();
    });
    function addGenre(){
        var formData = {
            genre :  $("#genre").val()
        }
        $.ajax({
            type : "POST",
            contentType : "application/json",
            url : "/addGenre",
            data : JSON.stringify(formData),
            dataType : "json",
            success : function(result) {
                createTableGenres(result);
                console.log("success add genre!");
            },
            error : function(e) {
                console.log("ERROR: ", e);
            }
        });
    }
})