package ru.otus.lesson8hw.repository.genre;

import ru.otus.lesson8hw.entity.Genre;

import java.util.List;

/**
 * Created by zhmv on 01.08.2018.
 */
public interface GenreRepository {
    public long count();
    public Genre getById(long id);
    public List<Genre> getAll();
    public void deleteById(long id);
    public void insert(Genre genre);
}
