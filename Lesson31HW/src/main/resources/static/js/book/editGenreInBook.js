function editGenreInBook(bookId, genres){
    var formData = genres[document.getElementById("genre-input").selectedIndex]
    $.ajax({
        type : "PUT",
        contentType : "application/json",
        url : "/books/"+bookId+"/editGenreInBook",
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