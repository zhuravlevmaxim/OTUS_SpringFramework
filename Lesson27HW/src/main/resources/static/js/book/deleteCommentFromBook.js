function deleteCommentFromBook(bookId, comment){
    var formData = comment;
    $.ajax({
        type : "PUT",
        contentType : "application/json",
        url : "/books/"+bookId+"/deleteCommentFromBook",
        data : JSON.stringify(formData),
        dataType : "json",
        success : function(result) {
            editBookForm(result);
            console.log("success delete comment in book: " + bookId);
        },
        error : function(e) {
            console.log("ERROR: ", e);
        }
    });
}