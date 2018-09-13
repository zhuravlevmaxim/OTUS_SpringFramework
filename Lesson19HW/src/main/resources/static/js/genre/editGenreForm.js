function editGenreForm(genre) {

    var mainDiv = document.getElementById("mainDiv");
    while (mainDiv.firstChild) {
        mainDiv.removeChild(mainDiv.firstChild);
    }

    var editGenreFormDiv = document.getElementById("mainDiv");
    var editGenreForm = document.createElement("FORM");

    var GenreIdP = document.createElement("P");
    GenreIdP.innerHTML = "Genre id: ";
    var genreIdInput = document.createElement("INPUT");
    genreIdInput.setAttribute("id", "id");
    genreIdInput.value = genre["id"];
    GenreIdP.appendChild(genreIdInput);
    editGenreForm.appendChild(GenreIdP);

    var genreGenreP = document.createElement("P");
    genreGenreP.innerHTML = "Genre: ";
    var genreGenreInput = document.createElement("INPUT");
    genreGenreInput.setAttribute("id", "genre");
    genreGenreInput.value = genre["genre"];
    genreGenreP.appendChild(genreGenreInput);
    editGenreForm.appendChild(genreGenreP);

    var buttonFormEditGenre = document.createElement("BUTTON");
    buttonFormEditGenre.innerHTML = "Edit genre";
    buttonFormEditGenre.setAttribute("type", "submit");
    buttonFormEditGenre.onclick = editGenre;
    editGenreForm.appendChild(buttonFormEditGenre);
    editGenreFormDiv.appendChild(editGenreForm);
}