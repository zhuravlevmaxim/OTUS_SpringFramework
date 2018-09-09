function createEditBook(book){

    var mainDiv = document. getElementById("mainDiv");
    while (mainDiv.firstChild) {
        mainDiv.removeChild(mainDiv.firstChild);
    }

    var editBookFormDiv = document.getElementById("mainDiv");
    var editBookForm = document.createElement("FORM");
    editBookForm.setAttribute("id", "editBookForm");

    var bookIdP = document.createElement("P");
    bookIdP.innerHTML = "Book id: ";
    var bookIdInput = document.createElement("INPUT");
    bookIdInput.setAttribute("id", "id");
    bookIdInput.value = book["id"];
    bookIdP.appendChild(bookIdInput);
    editBookForm.appendChild(bookIdP);

    var bookNameP = document.createElement("P");
    bookNameP.innerHTML = "Book name: ";
    var bookNameInput = document.createElement("INPUT");
    bookNameInput.setAttribute("id", "name");
    bookNameInput.value = book["name"];
    bookNameP.appendChild(bookNameInput);
    editBookForm.appendChild(bookNameP);

    var bookContentP = document.createElement("P");
    bookContentP.innerHTML = "Book content: ";
    var bookContentInput = document.createElement("INPUT");
    bookContentInput.setAttribute("id", "content");
    bookContentInput.value = book["content"];
    bookContentP.appendChild(bookContentInput);
    editBookForm.appendChild(bookContentP);

    var bookDescriptionP = document.createElement("P");
    bookDescriptionP.innerHTML = "Book description: ";
    var bookDescriptionInput = document.createElement("INPUT");
    bookDescriptionInput.setAttribute("id", "description");
    bookDescriptionInput.value = book["description"];
    bookDescriptionP.appendChild(bookDescriptionInput);
    editBookForm.appendChild(bookDescriptionP);

    var buttonFormCreateBook = document.createElement("BUTTON");
    buttonFormCreateBook.innerHTML = "Edit book";
    buttonFormCreateBook.setAttribute("type", "submit");
    // buttonFormCreateBook.setAttribute("id", "editBookForm");
    // buttonFormCreateBook.onclick = function(){
    //     editBook();
    // };
    editBookForm.appendChild(buttonFormCreateBook);
    editBookFormDiv.appendChild(editBookForm)

    /*
    var bookGenresP = document.createElement("P");
    var bookGenresLabel = document.createElement("LABEL");
    bookGenresLabel.innerHTML = "Genres: ";
    bookGenresLabel.setAttribute("for", "genre-input");
    bookGenresP.appendChild(bookGenresLabel);
    var bookGenresSelect = document.createElement("SELECT");
    bookGenresSelect.setAttribute("id", "genre-input");
    genres.forEach(function(genre){
        console.log(genre);
        var bookGenreOption = document.createElement("OPTION");
        bookGenreOption.setAttribute("id", "optionGenre");
        bookGenreOption.value = {
            id: genre.id,
            genre : genre.genre
        };
        bookGenreOption.text = genre["genre"];
        bookGenresSelect.appendChild(bookGenreOption);
    });
    bookGenresP.appendChild(bookGenresSelect);
    editBookFormDiv.appendChild(bookGenresP);

    var bookAuthorsP = document.createElement("P");
    var bookAuthorsLabel = document.createElement("LABEL");
    bookGenresLabel.innerHTML = "Authors: ";
    bookAuthorsLabel.setAttribute("for", "author-input");
    bookAuthorsP.appendChild(bookAuthorsLabel);
    var bookAuthorsSelect = document.createElement("SELECT");
    bookAuthorsSelect.setAttribute("id", "author-input");
    authors.forEach(function(author){
        var bookAuthorOption = document.createElement("OPTION");
        bookAuthorOption.value = author;
        bookAuthorOption.text = author["firstName"] + " : " +author["secondName"];
        bookAuthorsSelect.appendChild(bookAuthorOption);
    });
    bookAuthorsP.appendChild(bookAuthorsSelect);
    editBookFormDiv.appendChild(bookAuthorsP);
    */

}