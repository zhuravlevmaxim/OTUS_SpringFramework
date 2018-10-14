function createBookForm(){
    var genres = window.genres;
    var authors = window.authors;
    
    var createBookFormDiv = document.getElementById("createBookFormDiv");
    var createBookForm = document.createElement("FORM");
    createBookForm.setAttribute("id", "createBookForm");

    var bookNameP = document.createElement("P");
    bookNameP.innerHTML = "Book name: ";
    var bookNameInput = document.createElement("INPUT");
    bookNameInput.setAttribute("id", "name");
    bookNameP.appendChild(bookNameInput);
    createBookForm.appendChild(bookNameP);

    var bookContentP = document.createElement("P");
    bookContentP.innerHTML = "Book content: ";
    var bookContentInput = document.createElement("INPUT");
    bookContentInput.setAttribute("id", "content");
    bookContentP.appendChild(bookContentInput);
    createBookForm.appendChild(bookContentP);

    var bookDescriptionP = document.createElement("P");
    bookDescriptionP.innerHTML = "Book description: ";
    var bookDescriptionInput = document.createElement("INPUT");
    bookDescriptionInput.setAttribute("id", "description");
    bookDescriptionP.appendChild(bookDescriptionInput);
    createBookForm.appendChild(bookDescriptionP);

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
    createBookForm.appendChild(bookGenresP);

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
    createBookForm.appendChild(bookAuthorsP);

    var buttonFormCreateBook = document.createElement("BUTTON");
    buttonFormCreateBook.innerHTML = "Create new book";
    buttonFormCreateBook.setAttribute("type", "submit");
    createBookForm.appendChild(buttonFormCreateBook);
    createBookFormDiv.appendChild(createBookForm);
}