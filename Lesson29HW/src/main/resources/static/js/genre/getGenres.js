function getGenres(){
    var resultGenres = $.ajax({
        type : "POST",
        contentType : "application/json",
        url : "/genres",
        data : "",
        dataType : "json",
        success : function(result) {
            console.log("success table genres!");
        },
        error : function(e) {
            console.log("ERROR: ", e);
        },
        async : false
    });
    return resultGenres.responseText;
}