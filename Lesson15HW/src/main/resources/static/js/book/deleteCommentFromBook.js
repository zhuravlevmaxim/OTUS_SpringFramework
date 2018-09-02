$(document).ready(function() {
    $("#deleteCommentFromBook").submit(function (event) {
        event.preventDefault();
        deleteCommentFromBook();
    });
    function deleteCommentFromBook(){
        var formData = {
            id : $("#commentId").val(),
            comment :  $("#comment").val()
        }
        $.ajax({
            type : "POST",
            contentType : "application/json",
            url : "deleteCommentFromBook?id=" + $("#id").val(),
            data : JSON.stringify(formData),
            dataType : "json",
            success : function(result) {
                window.location.href = result;
                console.log("success delete comment from book!");
            },
            error : function(e) {
                console.log("ERROR: ", e);
            }
        });
    }
})