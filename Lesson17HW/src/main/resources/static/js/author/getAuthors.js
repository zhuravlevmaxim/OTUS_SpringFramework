function getAuthors(){
    var resultAuthors = $.ajax({
        type : "POST",
        contentType : "application/json",
        url : "/authors",
        data : "",
        dataType : "json",
        success : function(result) {
            console.log("success table authors!");
        },
        error : function(e) {
            console.log("ERROR: ", e);
        },
        async : false
    });
    return resultAuthors.responseText;
}