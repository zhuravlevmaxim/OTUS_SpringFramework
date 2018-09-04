function createTableAuthorsFromBook(authorsData){
    if(authorsData){
        var authorsT = authorsData;
        var authorsTable = document. getElementById("authorsTable");
        authorsTable. parentNode. removeChild(authorsTable);
    }else {
        var authorsT = window.authors;
    }
    var authorsTableDiv = document.getElementById("authorsTableDiv");

    var table = document.createElement("TABLE");
    table.setAttribute("id", "authorsTable");
    var tableBody = document.createElement("TBODY");
    var trHead = document.createElement("tr");

    var thIdAuthor = document.createElement("th");
    thIdAuthor.innerHTML = "Author id";
    var thFirstName = document.createElement("th");
    thFirstName.innerHTML = "Author first name";
    var thSecondName = document.createElement("th");
    thSecondName.innerHTML = "Author second name";
    var thDeleteAuthor = document.createElement("th");
    thDeleteAuthor.innerHTML = "Delete author";

    trHead.appendChild(thIdAuthor);
    trHead.appendChild(thFirstName);
    trHead.appendChild(thSecondName);
    trHead.appendChild(thDeleteAuthor);
    tableBody.appendChild(trHead);

    authorsT.forEach(function(rowData) {

        var tr = document.createElement("tr");
        var tdId = document.createElement("td");
        tdId.setAttribute("id", "idDelete");
        tdId.innerHTML = rowData["id"];
        var tdFirstName = document.createElement("td");
        tdFirstName.innerHTML = rowData["firstName"];
        var tdSecondName = document.createElement("td");
        tdSecondName.innerHTML = rowData["secondName"];
        var tdButtonDelete = document.createElement("td");
        var buttonDelete = document.createElement("BUTTON");
        var textButtonDelete = document.createTextNode("Delete author");
        buttonDelete.appendChild(textButtonDelete);
        buttonDelete.onclick = function(){
            deleteAuthorFromBook(rowData["id"], rowData["firstName"], rowData["secondName"]);
        };
        tdButtonDelete.appendChild(buttonDelete);

        tr.appendChild(tdId);
        tr.appendChild(tdFirstName);
        tr.appendChild(tdSecondName);
        tr.appendChild(tdButtonDelete);
        tableBody.appendChild(tr);
    });

    table.appendChild(tableBody);
    authorsTableDiv.appendChild(table);

}