function deleteBook(idDeleteBook){
    $.ajax({
        type : "DELETE",
        contentType : "application/json",
        url : "/books/" + idDeleteBook,
        data : "",
        dataType : "json",
        success : function(result) {
            createTableBooks(result);
            console.log("success delete book: " + idDeleteBook);
        },
        error : function(e) {
            console.log("ERROR: ", e);
        }
    });
}