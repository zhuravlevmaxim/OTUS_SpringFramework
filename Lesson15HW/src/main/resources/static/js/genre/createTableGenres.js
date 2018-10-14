function createTableGenres(genresData){
    if(genresData){
        var genresT = genresData;
        var genresTable = document. getElementById("genresTable");
        genresTable. parentNode. removeChild(genresTable);
    }else {
        var genresT = window.genres;
    }
    var genresTableDiv = document.getElementById("genresTableDiv");

    var table = document.createElement("TABLE");
    table.setAttribute("id", "genresTable");
    var tableBody = document.createElement("TBODY");
    var trHead = document.createElement("tr");

    var thIdGenre = document.createElement("th");
    thIdGenre.innerHTML = "Genre id";
    var thGenre = document.createElement("th");
    thGenre.innerHTML = "Genre";
    var thDeleteGenre = document.createElement("th");
    thDeleteGenre.innerHTML = "Delete genre";

    trHead.appendChild(thIdGenre);
    trHead.appendChild(thGenre);
    trHead.appendChild(thDeleteGenre);
    tableBody.appendChild(trHead);

    genresT.forEach(function(rowData) {

        var tr = document.createElement("tr");
        var tdId = document.createElement("td");
        tdId.setAttribute("id", "idDelete");
        var linkId = document.createElement("a");
        linkId.href = "/genre?id="+ rowData["id"];
        var linkIdText = document.createTextNode(rowData["id"]);
        linkId.appendChild(linkIdText);
        tdId.appendChild(linkId);
        var tdGenre = document.createElement("td");
        tdGenre.innerHTML = rowData["genre"];
        var tdButtonDelete = document.createElement("td");
        var buttonDelete = document.createElement("BUTTON");
        var textButtonDelete = document.createTextNode("Delete genre");
        buttonDelete.appendChild(textButtonDelete);
        buttonDelete.onclick = function(){
            deleteGenre(rowData["id"]);
        };
        tdButtonDelete.appendChild(buttonDelete);

        tr.appendChild(tdId);
        tr.appendChild(tdGenre);
        tr.appendChild(tdButtonDelete);
        tableBody.appendChild(tr);
    });

    table.appendChild(tableBody);
    genresTableDiv.appendChild(table);

}