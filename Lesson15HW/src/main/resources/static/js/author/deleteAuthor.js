$(document).ready(function() {
    $("#deleteAuthor").submit(function(event) {
        event.preventDefault();
        deleteAuthor();
    });
    function deleteAuthor(){
        var formData = {
            id: $("#idDelete").val(),
            firstName :  $("#firstNameDelete").val(),
            secondName :  $("#secondNameDelete").val()
        }
        $.ajax({
            type : "DELETE",
            contentType : "application/json",
            url : "deleteAuthor",
            data : JSON.stringify(formData),
            dataType : "json",
            success : function(result) {
                console.log(result);
            },
            error : function(e) {
                console.log("ERROR: ", e);
            }
        });
    }
})