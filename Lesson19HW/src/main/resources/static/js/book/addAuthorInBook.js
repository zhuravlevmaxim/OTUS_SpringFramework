function addAuthorInBook(bookId, authors){
    var formData = authors[document.getElementById("author-input").selectedIndex];
    $.ajax({
        type : "PUT",
        contentType : "application/json",
        url : "/books/"+bookId+"/addAuthorInBook",
        data : JSON.stringify(formData),
        dataType : "json",
        success : function(result) {
            editBookForm(result);
            console.log("success edit genre in book: " +result.id);
        },
        error : function(e) {
            console.log("ERROR: ", e);
        }
    });
}