INSERT INTO
    author_table (id, first_name, second_name, book_id)
VALUES
    (1, 'firstName', 'secondName', 1);

INSERT INTO
    book_comments_detail(comment_id, book_id)
VALUES
    (1, 1);

INSERT INTO
    book_table(id, name, description, author_id)
VALUES
    (1, 'book1', 'description1', 1);

INSERT INTO
    comment_table(id, comment)
VALUES(1, 'comment1');

INSERT INTO
    genre_table(id, genre, book_id)
VALUES
    (1, 'genre1', 1);