function createTableCommentsFromBook(commentsData){
    if(commentsData){
        var commentsT = commentsData;
        var commentsTable = document. getElementById("commentsTable");
        commentsTable. parentNode. removeChild(commentsTable);
    }else {
        var commentsT = window.comments;
    }
    var commentsTableDiv = document.getElementById("commentsTableDiv");

    var table = document.createElement("TABLE");
    table.setAttribute("id", "commentsTable");
    var tableBody = document.createElement("TBODY");
    var trHead = document.createElement("tr");

    var thIdComment = document.createElement("th");
    thIdComment.innerHTML = "Comment id";
    var thComment = document.createElement("th");
    thComment.innerHTML = "Comment: "
    var thDeleteComment = document.createElement("th");
    thDeleteComment.innerHTML = "Delete comment";

    trHead.appendChild(thIdComment);
    trHead.appendChild(thComment);
    trHead.appendChild(thDeleteComment);
    tableBody.appendChild(trHead);

    commentsT.forEach(function(rowData) {

        var tr = document.createElement("tr");
        var tdId = document.createElement("td");
        tdId.setAttribute("id", "idDelete");
        tdId.innerHTML = rowData["id"];
        var tdComment = document.createElement("td");
        tdComment.innerHTML = rowData["comment"];
        var tdButtonDelete = document.createElement("td");
        var buttonDelete = document.createElement("BUTTON");
        var textButtonDelete = document.createTextNode("Delete comment");
        buttonDelete.appendChild(textButtonDelete);
        buttonDelete.onclick = function(){
            deleteCommentFromBook(rowData["id"], rowData["comment"]);
        };
        tdButtonDelete.appendChild(buttonDelete);

        tr.appendChild(tdId);
        tr.appendChild(tdComment);
        tr.appendChild(tdButtonDelete);
        tableBody.appendChild(tr);
    });

    table.appendChild(tableBody);
    commentsTableDiv.appendChild(table);

}