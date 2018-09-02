$(document).ready(function() {
    $("#addAuthor").submit(function (event) {
        event.preventDefault();
        addAuthor();
    });
    function addAuthor(){
        var formData = {
            firstName :  $("#firstName").val(),
            secondName :  $("#secondName").val()
        }
        $.ajax({
            type : "POST",
            contentType : "application/text",
            url : "addAuthor",
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