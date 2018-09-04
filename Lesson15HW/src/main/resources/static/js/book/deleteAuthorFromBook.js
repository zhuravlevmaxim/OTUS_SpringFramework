    function deleteAuthorFromBook(idDeleteAuthor, firstNameAuthor, secondNameAuthor){
        var formData = {
            id: idDeleteAuthor,
            firstName :  firstNameAuthor,
            secondName :  secondNameAuthor
        }
        $.ajax({
            type : "DELETE",
            contentType : "application/json",
            url : "/deleteAuthorFromBook/" + window.book.id,
            data : JSON.stringify(formData),
            dataType : "json",
            success : function(result) {
                createTableAuthorsFromBook(result);
                console.log("success remove author from book!");
            },
            error : function(e) {
                console.log("ERROR: ", e);
            }
        });
    }