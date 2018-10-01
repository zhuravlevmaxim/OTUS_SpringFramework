$(document).ready(function() {
    $("#editBookForm").submit(function(event) {
        event.preventDefault();
        editBookPost();
    });
    function editBookPost(){
        var formData = {
            id : $("#id").val(),
            name :  $("#name").val(),
            description :  $("#description").val(),
            content :  $("#content").val()
        }
        $.ajax({
            type : "POST",
            contentType : "application/json",
            url : "editBook",
            data : JSON.stringify(formData),
            dataType : "json",
            success : function(result) {
                $("#id").innerHTML = result.id;
                $("#name").innerHTML = result.name;
                $("#description").innerHTML = result.description;
                $("#content").innerHTML = result.content;
            },
            error : function(e) {
                console.log("ERROR: ", e);
            }
        });
    }
})