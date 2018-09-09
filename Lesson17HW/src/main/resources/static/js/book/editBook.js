 $(document).ready(function() {
     $("#editBookForm").submit(function(event) {
         event.preventDefault();
         editBook();
     });
    function editBook(){
        var formData = {
            id : $("#id").val(),
            name :  $("#name").val(),
            description :  $("#description").val(),
            content :  $("#content").val()
        }
        $.ajax({
            type : "PUT",
            contentType : "application/json",
            url : "/books",
            data : JSON.stringify(formData),
            dataType : "json",
            success : function(result) {
                createEditBook(result);
                console.log("success edit book: " +result.id);
            },
            error : function(e) {
                console.log("ERROR: ", e);
            }
        });
     }
 })