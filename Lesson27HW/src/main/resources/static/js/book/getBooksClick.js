$(document).ready(function() {
    $("#getBooks").click(function (event) {
        event.preventDefault();
        createTableBooks(JSON.parse(getBooks()));
    });
})