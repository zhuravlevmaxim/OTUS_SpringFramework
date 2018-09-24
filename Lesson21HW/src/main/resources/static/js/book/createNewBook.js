function createNewBook(genres, authors){
    var formData = {
        name: $("#name").val(),
        description : $("#description").val(),
        content : $("#content").val(),
        genre : genres[document.getElementById("genre-input").selectedIndex],
        author : authors[document.getElementById("author-input").selectedIndex]
    }
    $.ajax({
        type : "POST",
        contentType : "application/json",
        url : "/books/createNewBook",
        data : JSON.stringify(formData),
        dataType : "json",
        success : function(result) {
            createTableBooks(result);
            console.log("success create new book");
        },
        error : function(e) {
            console.log("ERROR: ", e);
        }
    });
}