function deleteAuthorFromBook(bookId, author){
    var formData = author;
    $.ajax({
        type : "PUT",
        contentType : "application/json",
        url : "/books/"+bookId+"/deleteAuthorFromBook",
        data : JSON.stringify(formData),
        dataType : "json",
        success : function(result) {
            editBookForm(result);
            console.log("success delete author in book: " + bookId);
        },
        error : function(e) {
            console.log("ERROR: ", e);
        }
    });
}