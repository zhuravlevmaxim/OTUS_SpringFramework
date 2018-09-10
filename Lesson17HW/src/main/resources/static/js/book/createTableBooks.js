function createTableBooks(booksData){

    var mainDiv = document. getElementById("mainDiv");
    while (mainDiv.firstChild) {
        mainDiv.removeChild(mainDiv.firstChild);
    }

    var booksTableDiv = document.getElementById("mainDiv");

    var buttonCreateNewBook = document.createElement("BUTTON");
    var textButtonCreateNewBook = document.createTextNode("Create new book");
    buttonCreateNewBook.appendChild(textButtonCreateNewBook);
    buttonCreateNewBook.onclick = function(){
        createNewBookForm();
    };
    booksTableDiv.appendChild(buttonCreateNewBook);

    var table = document.createElement("TABLE");
    table.setAttribute("id", "booksTable");
    var tableBody = document.createElement("TBODY");
    var trHead = document.createElement("tr");

    var thIdBook = document.createElement("th");
    thIdBook.innerHTML = "Book id";
    var thNameBook = document.createElement("th");
    thNameBook.innerHTML = "Book name";
    var thDescriptionBook = document.createElement("th");
    thDescriptionBook.innerHTML = "Book description";
    var thContentBook = document.createElement("th");
    thContentBook.innerHTML = "Book content";
    var thDeleteBook = document.createElement("th");
    thDeleteBook.innerHTML = "Book delete";
    trHead.appendChild(thIdBook);
    trHead.appendChild(thNameBook);
    trHead.appendChild(thDescriptionBook);
    trHead.appendChild(thContentBook);
    trHead.appendChild(thDeleteBook);
    tableBody.appendChild(trHead);

    booksData.forEach(function(book) {
        var tr = document.createElement("tr");
        var tdId = document.createElement("td");
        tdId.setAttribute("id", "idDelete");
        var linkId = document.createElement("a");
        linkId.href= "#" + book.id;
        linkId.onclick = function(){
            editBookForm(book);
        };
        var linkIdText = document.createTextNode(book["id"]);
        linkId.appendChild(linkIdText);
        tdId.appendChild(linkId);
        var tdNameBook = document.createElement("td");
        tdNameBook.innerHTML = book["name"];
        var tdDescriptionBook = document.createElement("td");
        tdDescriptionBook.innerHTML = book["description"];
        var tdContentBook = document.createElement("td");
        tdContentBook.innerHTML = book["content"];
        var tdButtonDelete = document.createElement("td");
        var buttonDelete = document.createElement("BUTTON");
        var textButtonDelete = document.createTextNode("Delete book");
        buttonDelete.appendChild(textButtonDelete);
        buttonDelete.onclick = function(){
            deleteBook(book["id"]);
        };
        tdButtonDelete.appendChild(buttonDelete);

        tr.appendChild(tdId);
        tr.appendChild(tdNameBook);
        tr.appendChild(tdDescriptionBook);
        tr.appendChild(tdContentBook);
        tr.appendChild(tdButtonDelete);
        tableBody.appendChild(tr);
    });

    table.appendChild(tableBody);
    booksTableDiv.appendChild(table);
}