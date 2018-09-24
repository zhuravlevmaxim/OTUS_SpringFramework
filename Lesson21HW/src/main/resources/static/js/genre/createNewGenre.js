function createNewGenre(){
    var formData = {
        genre :  $("#genreCreate").val()
    }
    $.ajax({
        type : "POST",
        contentType : "application/json",
        url : "/genres/createNewGenre",
        data : JSON.stringify(formData),
        dataType : "json",
        success : function(result) {
            createTableGenres(result);
            console.log("success create new genre: " +result.id);
        },
        error : function(e) {
            console.log("ERROR: ", e);
        }
    });
}