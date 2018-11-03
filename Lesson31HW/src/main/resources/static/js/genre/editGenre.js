function editGenre(){
    var formData = {
        id : $("#id").val(),
        genre :  $("#genre").val()
    }
    $.ajax({
        type : "PUT",
        contentType : "application/json",
        url : "/genres",
        data : JSON.stringify(formData),
        dataType : "json",
        success : function(result) {
            editGenreForm(result);
            console.log("success edit genre: " +result.id);
        },
        error : function(e) {
            console.log("ERROR: ", e);
        }
    });
}