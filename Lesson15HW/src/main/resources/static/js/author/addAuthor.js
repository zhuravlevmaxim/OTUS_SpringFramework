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
            contentType : "application/json",
            url : "/addAuthor",
            data : JSON.stringify(formData),
            dataType : "json",
            success : function(result) {
                $("#firstName").innerHTML = "";
                $("#secondName").innerHTML = "";
                createTableAuthors(result);
                console.log("success add author!");
            },
            error : function(e) {
                console.log("ERROR: ", e);
            }
        });
    }
})