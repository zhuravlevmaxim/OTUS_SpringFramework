function createTableGenres(genresData){

    var mainDiv = document. getElementById("mainDiv");
    while (mainDiv.firstChild) {
        mainDiv.removeChild(mainDiv.firstChild);
    }

    var genresTableDiv = document.getElementById("mainDiv");

    var createGenreForm = document.createElement("FORM");
    var genreGenreCreateP = document.createElement("P");
    genreGenreCreateP.innerHTML = "Genre: ";
    var genreGenreCreateInput = document.createElement("INPUT");
    genreGenreCreateInput.setAttribute("id", "genreCreate");
    genreGenreCreateP.appendChild(genreGenreCreateInput);
    createGenreForm.appendChild(genreGenreCreateP);
    var buttonFormCreateGenre = document.createElement("BUTTON");
    buttonFormCreateGenre.innerHTML = "Create new genre";
    buttonFormCreateGenre.setAttribute("type", "submit");
    buttonFormCreateGenre.onclick = createNewGenre;
    createGenreForm.appendChild(buttonFormCreateGenre);

    genresTableDiv.appendChild(createGenreForm);

    var table = document.createElement("TABLE");
    table.setAttribute("id", "genresTable");
    var tableBody = document.createElement("TBODY");
    var trHead = document.createElement("tr");

    var thIdGenre = document.createElement("th");
    thIdGenre.innerHTML = "Genre id";
    var thGenreGenre = document.createElement("th");
    thGenreGenre.innerHTML = "Genre: ";
    var thDeleteGenre = document.createElement("th");
    thDeleteGenre.innerHTML = "Delete genre";

    trHead.appendChild(thIdGenre);
    trHead.appendChild(thGenreGenre);
    trHead.appendChild(thDeleteGenre);
    tableBody.appendChild(trHead);

    genresData.forEach(function(genre) {

        var tr = document.createElement("tr");
        var tdId = document.createElement("td");
        tdId.setAttribute("id", "idDelete");
        var linkId = document.createElement("a");
        linkId.href= "#" + genre.id;
        linkId.onclick = function(){
            editGenreForm(genre);
        };
        var linkIdText = document.createTextNode(genre["id"]);
        linkId.appendChild(linkIdText);
        tdId.appendChild(linkId);
        var tdGenreGenre = document.createElement("td");
        tdGenreGenre.innerHTML = genre["genre"];
        var tdButtonDelete = document.createElement("td");
        var buttonDelete = document.createElement("BUTTON");
        var textButtonDelete = document.createTextNode("Delete genre");
        buttonDelete.appendChild(textButtonDelete);
        buttonDelete.onclick = function(){
            deleteGenre(genre["id"]);
        };
        tdButtonDelete.appendChild(buttonDelete);

        tr.appendChild(tdId);
        tr.appendChild(tdGenreGenre);
        tr.appendChild(tdButtonDelete);
        tableBody.appendChild(tr);
    });

    table.appendChild(tableBody);
    genresTableDiv.appendChild(table);
}