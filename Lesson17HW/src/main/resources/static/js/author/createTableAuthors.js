function createTableAuthors(authorsData){

    var mainDiv = document. getElementById("mainDiv");
    while (mainDiv.firstChild) {
        mainDiv.removeChild(mainDiv.firstChild);
    }

    var authorsTableDiv = document.getElementById("mainDiv");
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

    authorsData.forEach(function(author) {

        var tr = document.createElement("tr");
        var tdId = document.createElement("td");
        tdId.setAttribute("id", "idDelete");
        var linkId = document.createElement("a");
        linkId.href = "/author?id="+ author["id"];
        var linkIdText = document.createTextNode(author["id"]);
        linkId.appendChild(linkIdText);
        tdId.appendChild(linkId);
        var tdFirstName = document.createElement("td");
        tdFirstName.innerHTML = author["firstName"];
        var tdSecondName = document.createElement("td");
        tdSecondName.innerHTML = author["secondName"];
        var tdButtonDelete = document.createElement("td");
        var buttonDelete = document.createElement("BUTTON");
        var textButtonDelete = document.createTextNode("Delete author");
        buttonDelete.appendChild(textButtonDelete);
        buttonDelete.onclick = function(){
            deleteAuthor(author["id"]);
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