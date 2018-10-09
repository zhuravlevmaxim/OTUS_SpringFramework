function addCommentInBook(bookId){
    var formData = {
        comment : $("#addComment").val()
    }
    $.ajax({
        type : "PUT",
        contentType : "application/json",
        url : "/books/"+bookId+"/addCommentInBook",
        data : JSON.stringify(formData),
        dataType : "json",
        success : function(result) {
            editBookForm(result);
            console.log("success add comment in  book: " +bookId);
        },
        error : function(e) {
            console.log("ERROR: ", e);
        }
    });
}