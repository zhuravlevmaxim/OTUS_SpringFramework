    function deleteCommentFromBook(idDeleteComment, commentDeleteComment){
        var formData = {
            id : idDeleteComment,
            comment :  commentDeleteComment
        }
        $.ajax({
            type : "DELETE",
            contentType : "application/json",
            url : "/deleteCommentFromBook/" + window.book.id,
            data : JSON.stringify(formData),
            dataType : "json",
            success : function(result) {
                createTableCommentsFromBook(result);
                console.log("success delete comment from book!");
            },
            error : function(e) {
                console.log("ERROR: ", e);
            }
        });
    }