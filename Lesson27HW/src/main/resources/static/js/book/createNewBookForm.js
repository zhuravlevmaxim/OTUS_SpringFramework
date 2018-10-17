function createNewBookForm(){

    var mainDiv = document. getElementById("mainDiv");
    while (mainDiv.firstChild) {
        mainDiv.removeChild(mainDiv.firstChild);
    }

    var createNewBookFormDiv = document.getElementById("mainDiv");
    var createNewBookForm = document.createElement("FORM");
    createNewBookForm.setAttribute("id", "editBookForm");

    var bookNameP = document.createElement("P");
    bookNameP.innerHTML = "Book name: ";
    var bookNameInput = document.createElement("INPUT");
    bookNameInput.setAttribute("id", "name");
    bookNameP.appendChild(bookNameInput);
    createNewBookForm.appendChild(bookNameP);

    var bookContentP = document.createElement("P");
    bookContentP.innerHTML = "Book content: ";
    var bookContentInput = document.createElement("INPUT");
    bookContentInput.setAttribute("id", "content");
    bookContentP.appendChild(bookContentInput);
    createNewBookForm.appendChild(bookContentP);

    var bookDescriptionP = document.createElement("P");
    bookDescriptionP.innerHTML = "Book description: ";
    var bookDescriptionInput = document.createElement("INPUT");
    bookDescriptionInput.setAttribute("id", "description");
    bookDescriptionP.appendChild(bookDescriptionInput);
    createNewBookForm.appendChild(bookDescriptionP);

    //genre
    var bookGenresP = document.createElement("P");
    var bookGenresLabel = document.createElement("LABEL");
    bookGenresLabel.innerHTML = "Genres: ";
    bookGenresLabel.setAttribute("for", "genre-input");
    bookGenresP.appendChild(bookGenresLabel);
    var bookGenresSelect = document.createElement("SELECT");
    bookGenresSelect.setAttribute("id", "genre-input");
    var genres = JSON.parse(getGenres());
    genres.forEach(function(genre){
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
    createNewBookForm.appendChild(bookGenresP);

    var bookAuthorsP = document.createElement("P");
    var bookAuthorsLabel = document.createElement("LABEL");
    bookAuthorsLabel.innerHTML = "Authors: ";
    bookAuthorsLabel.setAttribute("for", "author-input");
    bookAuthorsP.appendChild(bookAuthorsLabel);
    var bookAuthorsSelect = document.createElement("SELECT");
    bookAuthorsSelect.setAttribute("id", "author-input");
    var authors = JSON.parse(getAuthors());
    authors.forEach(function(author){
        var bookAuthorOption = document.createElement("OPTION");
        bookAuthorOption.setAttribute("id", "optionAuthor");
        bookAuthorOption.value = {
            id: author.id,
            firstName : author.firstName,
            secondName : author.secondName
        };
        bookAuthorOption.text = author.firstName + " : " + author.secondName;
        bookAuthorsSelect.appendChild(bookAuthorOption);
    });
    bookAuthorsP.appendChild(bookAuthorsSelect);
    createNewBookForm.appendChild(bookAuthorsP);
    createNewBookFormDiv.appendChild(createNewBookForm);

    var buttonFormCreateNewBook = document.createElement("BUTTON");
    buttonFormCreateNewBook.innerHTML = "Create new book";
    buttonFormCreateNewBook.setAttribute("type", "submit");
    buttonFormCreateNewBook.onclick = function(){
        createNewBook(genres, authors);
    };
    createNewBookFormDiv.appendChild(buttonFormCreateNewBook);
}