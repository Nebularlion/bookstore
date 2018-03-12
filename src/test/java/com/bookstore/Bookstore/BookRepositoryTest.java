package com.bookstore.Bookstore;

import com.bookstore.Bookstore.model.Book;
import com.bookstore.Bookstore.model.Category;
import com.bookstore.Bookstore.repository.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository repository;

    @Test
    public void findByAuthorShouldReturnBook(){
        List<Book> books = repository.findByAuthor();
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor().isEqualTo(""));
    }

    @Test
    public void createNewBook(){
        Book book = new Book("ABC", "Unknown", "1800", "14474354-n", "18.00", new Category("School"));
        repository.save(book);
        assertThat(book.getId().isNotNull());
    }
}
