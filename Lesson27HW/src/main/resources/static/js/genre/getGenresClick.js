$(document).ready(function() {
    $("#getGenres").click(function (event) {
        event.preventDefault();
        createTableGenres(JSON.parse(getGenres()));
    });
})