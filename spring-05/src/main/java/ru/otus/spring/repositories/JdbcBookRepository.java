package ru.otus.spring.repositories;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import ru.otus.spring.models.Author;
import ru.otus.spring.models.Book;
import ru.otus.spring.models.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class JdbcBookRepository implements BookRepository {

    private final GenreRepository genreRepository;

    private final AuthorRepository authorRepository;

    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    @Override
    public Optional<Book> findById(long id) {
        return Optional.empty();
    }

    @Override
    public List<Book> findAll() {
        var genres = genreRepository.findAll();
        var relations = getAllGenreRelations();
        var books = getAllBooksWithoutGenres();
        mergeBooksInfo(books, genres, relations);
        return books;
    }

    @Override
    public Book save(Book book) {
        if (book.getId() == 0) {
            return insert(book);
        }
        return update(book);
    }

    @Override
    public void deleteById(long id) {
        removeGenresRelationsFor(new Book(id, null, null, null));
        Map<String, Object> params = Collections.singletonMap("id", id);
        namedParameterJdbcOperations.update("delete from books where id = :id", params);
    }

    private List<Book> getAllBooksWithoutGenres() {
        String sql = "SELECT b.id AS book_id, b.title AS book_title, a.id AS author_id, a.name AS author_name" +
                "FROM books b JOIN authors a ON b.author_id = a.id";
        return namedParameterJdbcOperations.query(sql, new BookRowMapper());
    }

    private List<BookGenreRelation> getAllGenreRelations() {
        String sql = "SELECT book_id, genre_id FROM book_genres";
        return namedParameterJdbcOperations.query(sql, (rs, rowNum) ->
                new BookGenreRelation(rs.getLong("book_id"), rs.getLong("genre_id")));
    }

    private void mergeBooksInfo(List<Book> booksWithoutGenres, List<Genre> genres,
                                List<BookGenreRelation> relations) {
        // Добавить книгам (booksWithoutGenres) жанры (genres) в соответствии со связями (relations)
        Map<Long, Book> books = booksWithoutGenres.stream().collect(Collectors.toMap(Book::getId, book -> book));
        Map<Long, Genre> genresMap = genres.stream().collect(Collectors.toMap(Genre::getId, g -> g));
        relations.forEach(relation -> {
            Book book = books.get(relation.bookId);
            Genre genre = genresMap.get(relation.genreId);
            if (book != null && genre != null) {
            book.addGenre(genre);
        }});
    }

    private Book insert(Book book) {
        var keyHolder = new GeneratedKeyHolder();

        //...

        //noinspection DataFlowIssue
        book.setId(keyHolder.getKeyAs(Long.class));
        batchInsertGenresRelationsFor(book);
        return book;
    }

    private Book update(Book book) {
        //...

        // Выбросить EntityNotFoundException если не обновлено ни одной записи в БД
        removeGenresRelationsFor(book);
        batchInsertGenresRelationsFor(book);

        return book;
    }

    private void batchInsertGenresRelationsFor(Book book) {
        // Использовать метод batchUpdate
    }

    private void removeGenresRelationsFor(Book book) {
        Map<String, Object> params = Collections.singletonMap("book_id", book.getId());
        namedParameterJdbcOperations.update("DELETE FROM book_genres WHERE book_id = :book_id", params);
    }

    private static class BookRowMapper implements RowMapper<Book> {

        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            Author author = new Author(
                    rs.getLong("author_id"),
                    rs.getString("author_name")
            );
            return new Book(rs.getLong("book_id"), rs.getString("book_title"),
                    author, null);
        }
    }

    // Использовать для findById
    @SuppressWarnings("ClassCanBeRecord")
    @RequiredArgsConstructor
    private static class BookResultSetExtractor implements ResultSetExtractor<Book> {

        @Override
        public Book extractData(ResultSet rs) throws SQLException, DataAccessException {
            return null;
        }
    }

    private record BookGenreRelation(long bookId, long genreId) {
    }
}