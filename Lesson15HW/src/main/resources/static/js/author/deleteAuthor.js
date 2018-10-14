 function deleteAuthor(idDeleteAuthor){
        var formData = {
            id: idDeleteAuthor
        }
        $.ajax({
            type : "DELETE",
            contentType : "application/json",
            url : "/deleteAuthor/" + idDeleteAuthor,
            data : JSON.stringify(formData),
            dataType : "json",
            success : function(result) {
                console.log(result);
                createTableAuthors(result);
            },
            error : function(e) {
                console.log("ERROR: ", e);
            }
        });
}