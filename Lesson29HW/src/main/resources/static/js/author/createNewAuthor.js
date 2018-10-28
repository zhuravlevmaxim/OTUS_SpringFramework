function createNewAuthor(){
    var formData = {
        firstName :  $("#firstNameCreate").val(),
        secondName :  $("#secondNameCreate").val()
    }
    $.ajax({
        type : "POST",
        contentType : "application/json",
        url : "/authors/createNewAuthor",
        data : JSON.stringify(formData),
        dataType : "json",
        success : function(result) {
            createTableAuthors(result);
            console.log("success create new author: " +result.id);
        },
        error : function(e) {
            console.log("ERROR: ", e);
        }
    });
}