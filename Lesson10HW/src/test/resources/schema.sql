CREATE TABLE author_table (
  id          INTEGER PRIMARY KEY AUTO_INCREMENT,
  first_name  VARCHAR(255),
  second_name VARCHAR(255),
  book_id     INTEGER
);

CREATE TABLE book_comments_detail(
  comment_id  INTEGER,
  book_id     INTEGER
);

CREATE TABLE book_table(
  id          INTEGER PRIMARY KEY AUTO_INCREMENT,
  name        VARCHAR(255),
  description VARCHAR(255),
  author_id   INTEGER
);

CREATE TABLE comment_table(
  id         INTEGER PRIMARY KEY AUTO_INCREMENT,
  comment    VARCHAR(255)
);

CREATE TABLE genre_table(
  id         INTEGER PRIMARY KEY AUTO_INCREMENT,
  genre      VARCHAR(255),
  book_id    INTEGER
);