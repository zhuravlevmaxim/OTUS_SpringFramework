$(document).ready(function() {
    $("#createBookForm").submit(function (event) {
        event.preventDefault();
        createBook();
    });
    function createBook(){
        var formData = {
            name :  $("#name").val(),
            content: $("#content").val(),
            description :  $("#description").val(),
            genre : genres[document.getElementById("genre-input").selectedIndex],
            author : authors[document.getElementById("author-input").selectedIndex]
        }
        $.ajax({
            type : "PUT",
            contentType : "application/json",
            url : "/saveBook",
            data : JSON.stringify(formData),
            dataType : "json",
            success : function(result) {
                window.location.href = "/book?id="+result
                console.log("success create book!");
            },
            error : function(e) {
                console.log("ERROR: ", e);
            }
        });
    }
})