function deleteAuthor(idDeleteAuthor){
    $.ajax({
        type : "DELETE",
        contentType : "application/json",
        url : "/authors/" + idDeleteAuthor,
        data : "",
        dataType : "json",
        success : function(result) {
            console.log("success delete author: " +idDeleteAuthor);
            createTableAuthors(result);
        },
        error : function(e) {
            console.log("ERROR: ", e);
        }
    });
}