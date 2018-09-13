function deleteGenre(idDeleteGenre){
    $.ajax({
        type : "DELETE",
        contentType : "application/json",
        url : "/genres/" + idDeleteGenre,
        data : "",
        dataType : "json",
        success : function(result) {
            console.log("success delete genre: " +idDeleteGenre);
            createTableGenres(result);
        },
        error : function(e) {
            console.log("ERROR: ", e);
        }
    });
}