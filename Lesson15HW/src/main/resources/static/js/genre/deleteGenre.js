 function deleteGenre(idDeleteGenre){
        var formData = {
            id: idDeleteGenre
        }
        $.ajax({
            type : "DELETE",
            contentType : "application/json",
            url : "/deleteGenre/" + idDeleteGenre,
            data : JSON.stringify(formData),
            dataType : "json",
            success : function(result) {
                createTableGenres(result);
                console.log("success delete genre!");
            },
            error : function(e) {
                console.log("ERROR: ", e);
            }
        });
}