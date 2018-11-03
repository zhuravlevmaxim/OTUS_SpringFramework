function editBookForm(book){

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
    buttonFormCreateBook.onclick = editBook;
    editBookForm.appendChild(buttonFormCreateBook);
    editBookFormDiv.appendChild(editBookForm);

    var bookGenreIdP = document.createElement("P");
    bookGenreIdP.innerHTML = "Genre id: " + book["genre"]["id"];
    editBookFormDiv.appendChild(bookGenreIdP);

    var bookGenreGenreP = document.createElement("P");
    bookGenreGenreP.innerHTML = "Genre: " + book["genre"]["genre"];
    editBookFormDiv.appendChild(bookGenreGenreP);

    var editGenreBookForm = document.createElement("FORM");
    var bookGenresP = document.createElement("P");
    var bookGenresLabel = document.createElement("LABEL");
    bookGenresLabel.innerHTML = "Genres: ";
    bookGenresLabel.setAttribute("for", "genre-input");
    bookGenresP.appendChild(bookGenresLabel);
    var bookGenresSelect = document.createElement("SELECT");
    bookGenresSelect.setAttribute("id", "genre-input");
    bookGenresSelect.value = book.genre.id;
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
    editGenreBookForm.appendChild(bookGenresP);
    var buttonFormEditGenreBook = document.createElement("BUTTON");
    buttonFormEditGenreBook.innerHTML = "Edit genre in book";
    buttonFormEditGenreBook.setAttribute("type", "submit");
    buttonFormEditGenreBook.onclick = function(){
        editGenreInBook(book.id, genres);
    };
    editGenreBookForm.appendChild(buttonFormEditGenreBook);
    editBookFormDiv.appendChild(editGenreBookForm);

    var addAuthorBookForm = document.createElement("FORM");
    var bookAuthorsP = document.createElement("P");
    var bookAuthorsLabel = document.createElement("LABEL");
    bookAuthorsLabel.innerHTML = "Authors: ";
    bookAuthorsLabel.setAttribute("for", "author-input");
    bookAuthorsP.appendChild(bookAuthorsLabel);
    var bookAuthorsSelect = document.createElement("SELECT");
    bookAuthorsSelect.setAttribute("id", "author-input");
    //bookAuthorsSelect.value = book.author.id;
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
    addAuthorBookForm.appendChild(bookAuthorsP);
    var buttonFormAddAuthorBook = document.createElement("BUTTON");
    buttonFormAddAuthorBook.innerHTML = "Add author in book";
    buttonFormAddAuthorBook.setAttribute("type", "submit");
    buttonFormAddAuthorBook.onclick = function(){
        addAuthorInBook(book.id, authors);
    };
    addAuthorBookForm.appendChild(buttonFormAddAuthorBook);
    editBookFormDiv.appendChild(addAuthorBookForm);

    var tableAuthors = document.createElement("TABLE");
    tableAuthors.setAttribute("id", "authorsTable");
    var tableBodyAuthors = document.createElement("TBODY");
    var trHeadAuthors = document.createElement("tr");

    var thIdTableAuthors = document.createElement("th");
    thIdTableAuthors.innerHTML = "Author id";
    var thFirstNameTableAuthors = document.createElement("th");
    thFirstNameTableAuthors.innerHTML = "Author first name";
    var thSecondNameTableAuthors = document.createElement("th");
    thSecondNameTableAuthors.innerHTML = "Author second name";
    var thDeleteAuthor = document.createElement("th");
    thDeleteAuthor.innerHTML = "Delete author";

    trHeadAuthors.appendChild(thIdTableAuthors);
    trHeadAuthors.appendChild(thFirstNameTableAuthors);
    trHeadAuthors.appendChild(thSecondNameTableAuthors);
    trHeadAuthors.appendChild(thDeleteAuthor);
    tableBodyAuthors.appendChild(trHeadAuthors);

    book.authors.forEach(function(author) {
        var trTableAuthors = document.createElement("tr");
        var tdIdTableAuthors = document.createElement("td");
        tdIdTableAuthors.setAttribute("id", "idDelete");
        tdIdTableAuthors.innerHTML = author["id"];
        var tdFirstNameTableAuthors = document.createElement("td");
        tdFirstNameTableAuthors.innerHTML = author["firstName"];
        var tdSecondNameTableAuthors = document.createElement("td");
        tdSecondNameTableAuthors.innerHTML = author["secondName"];
        var tdButtonDeleteTableAuthors = document.createElement("td");
        var buttonDeleteTableAuthors = document.createElement("BUTTON");
        var textButtonDeleteTableAuthors = document.createTextNode("Delete author from book");
        buttonDeleteTableAuthors.appendChild(textButtonDeleteTableAuthors);
        buttonDeleteTableAuthors.onclick = function(){
            deleteAuthorFromBook(book.id, author);
        };
        tdButtonDeleteTableAuthors.appendChild(buttonDeleteTableAuthors);
        trTableAuthors.appendChild(tdIdTableAuthors);
        trTableAuthors.appendChild(tdFirstNameTableAuthors);
        trTableAuthors.appendChild(tdSecondNameTableAuthors);
        trTableAuthors.appendChild(tdButtonDeleteTableAuthors);
        tableBodyAuthors.appendChild(trTableAuthors);
    });

    tableAuthors.appendChild(tableBodyAuthors);
    editBookFormDiv.appendChild(tableAuthors);


    var addCommentCreateForm = document.createElement("FORM");
    addCommentCreateForm.setAttribute("id", "addCommentForm");

    var commentCommentP = document.createElement("P");
    commentCommentP.innerHTML = "Comment: ";
    var commentCommentInput = document.createElement("INPUT");
    commentCommentInput.setAttribute("id", "addComment");
    commentCommentP.appendChild(commentCommentInput);
    editBookFormDiv.appendChild(commentCommentP);

    var buttonFormAddCommentCreate = document.createElement("BUTTON");
    buttonFormAddCommentCreate.innerHTML = "Add new comment";
    buttonFormAddCommentCreate.setAttribute("type", "submit");
    buttonFormAddCommentCreate.onclick = function(){
        addCommentInBook(book.id)
    };
    addCommentCreateForm.appendChild(buttonFormAddCommentCreate);
    editBookFormDiv.appendChild(addCommentCreateForm);

    var tableComments = document.createElement("TABLE");
    tableComments.setAttribute("id", "commentsTable");
    var tableBodyComments = document.createElement("TBODY");
    var trHeadComments = document.createElement("tr");

    var thIdTableComments = document.createElement("th");
    thIdTableComments.innerHTML = "Comment id";
    var thCommentTableComments = document.createElement("th");
    thFirstNameTableAuthors.innerHTML = "Comment: ";
    var thDeleteAuthor = document.createElement("th");
    thDeleteAuthor.innerHTML = "Delete comment";

    trHeadComments.appendChild(thIdTableComments);
    trHeadComments.appendChild(thCommentTableComments);
    trHeadComments.appendChild(thDeleteAuthor);
    tableBodyComments.appendChild(trHeadComments);

    book.comments.forEach(function(comment) {
        var trTableComments = document.createElement("tr");
        var tdIdTableComments = document.createElement("td");
        tdIdTableComments.innerHTML = comment["id"];
        var tdCommentTableComments = document.createElement("td");
        tdCommentTableComments.innerHTML = comment["comment"];
        var tdButtonDeleteTableComments = document.createElement("td");
        var buttonDeleteTableComments = document.createElement("BUTTON");
        var textButtonDeleteTableComments = document.createTextNode("Delete comment from book");
        buttonDeleteTableComments.appendChild(textButtonDeleteTableComments);
        buttonDeleteTableComments.onclick = function(){
            deleteCommentFromBook(book.id, comment);
        };
        tdButtonDeleteTableComments.appendChild(buttonDeleteTableComments);
        trTableComments.appendChild(tdIdTableComments);
        trTableComments.appendChild(tdCommentTableComments);
        trTableComments.appendChild(tdButtonDeleteTableComments);
        tableBodyComments.appendChild(trTableComments);
    });

    tableComments.appendChild(tableBodyComments);
    editBookFormDiv.appendChild(tableComments);


}