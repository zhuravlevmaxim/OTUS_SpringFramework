$(document).ready(function() {
    $("#deleteAuthorFromBook").submit(function (event) {
        event.preventDefault();
        deleteAuthorFormBook();
    });
    function deleteAuthorFormBook(){
        var formData = {
            id : $("#authorId").val(),
            firstName :  $("#firstName").val(),
            secondName :  $("#secondName").val()
        }
        $.ajax({
            type : "POST",
            contentType : "application/text",
            url : "deleteAuthorFromBook?id=" + $("#id").val(),
            data : JSON.stringify(formData),
            dataType : "json",
            success : function(result) {
                window.location.href = result;
                console.log("success remove author from book!");
            },
            error : function(e) {
                console.log("ERROR: ", e);
            }
        });
    }
})