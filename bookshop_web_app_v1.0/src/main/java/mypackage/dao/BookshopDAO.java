package mypackage.dao;

import mypackage.models.Author;
import mypackage.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookshopDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookshopDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Author> getAuthorsList() {
        return jdbcTemplate.query("select * from Author", new BeanPropertyRowMapper<>(Author.class));
    } //select * from book where id in (select author_book.book_id from author_book where author_book.author_id = 1);

    public List<Book> getBooksList() {
        return jdbcTemplate.query("select * from Book", new BeanPropertyRowMapper<>(Book.class));
    }

    public List<Book> show(int id) {
        return jdbcTemplate.query("select * from book where id in (select author_book.book_id from author_book where author_book.author_id=?)",
                                  new Object[]{id},
                                  new BeanPropertyRowMapper<>(Book.class));
    }

    public List<Author> showAuthor(int id) {
        return jdbcTemplate.query("select * from author where id in (select author_book.author_id from author_book where author_book.book_id=?);",
                                  new Object[]{id},
                                  new BeanPropertyRowMapper<>(Author.class));
    }
}
