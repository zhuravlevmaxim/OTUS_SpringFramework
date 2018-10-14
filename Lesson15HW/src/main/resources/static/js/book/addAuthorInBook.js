$(document).ready(function() {
    $("#addAuthorInBook").submit(function (event) {
        event.preventDefault();
        addAuthorInBook();
    });
    function addAuthorInBook(){
        $.ajax({
            type : "POST",
            contentType : "application/text",
            url : "addAuthorInBook?id=" + $("#id").val(),
            data : $("#author-inputAdd").val(),
            dataType : "text",
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