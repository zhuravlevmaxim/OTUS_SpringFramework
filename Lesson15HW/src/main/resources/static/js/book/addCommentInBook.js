$(document).ready(function() {
    $("#addCommentInBook").submit(function (event) {
        event.preventDefault();
        addCommentInBook();
    });
    function addCommentInBook(){
        var formData = {
            comment :  $("#addComment").val()
        }
        $.ajax({
            type : "POST",
            contentType : "application/json",
            url : "addCommentInBook?id=" + $("#id").val(),
            data : JSON.stringify(formData),
            dataType : "json",
            success : function(result) {
                window.location.href = result;
                console.log("success add author in book!");
            },
            error : function(e) {
                console.log("ERROR: ", e);
            }
        });
    }
})