CREATE TABLE author_table (
  id          INTEGER PRIMARY KEY,
  first_name  VARCHAR(255),
  second_name VARCHAR(255),
  book_id     INTEGER
);

CREATE TABLE book_comments_detail(
  comment_id  INTEGER,
  book_id     INTEGER
);

CREATE TABLE book_table(
  id          INTEGER PRIMARY KEY,
  name        VARCHAR(255),
  description VARCHAR(255),
  author_id   INTEGER
);

CREATE TABLE comment_table(
  id         INTEGER PRIMARY KEY,
  comment    VARCHAR(255)
);

CREATE TABLE genre_table(
  id         INTEGER PRIMARY KEY,
  genre      VARCHAR(255),
  book_id    INTEGER
);