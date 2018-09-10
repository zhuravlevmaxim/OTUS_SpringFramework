function editAuthor(){
    var formData = {
        id : $("#id").val(),
        firstName :  $("#firstName").val(),
        secondName :  $("#secondName").val()
    }
    $.ajax({
        type : "PUT",
        contentType : "application/json",
        url : "/authors",
        data : JSON.stringify(formData),
        dataType : "json",
        success : function(result) {
            editAuthorForm(result);
            console.log("success edit author: " +result.id);
        },
        error : function(e) {
            console.log("ERROR: ", e);
        }
    });
}