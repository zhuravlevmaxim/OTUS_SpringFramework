$(document).ready(function() {
    $("#getAuthors").click(function (event) {
        event.preventDefault();
        createTableAuthors(JSON.parse(getAuthors()));
    });
})