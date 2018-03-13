package com.bookstore.Bookstore;

import com.bookstore.Bookstore.model.Book;
import com.bookstore.Bookstore.model.Category;
import com.bookstore.Bookstore.repository.BookRepository;
import org.junit.After;
import org.junit.Before;
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

    @Before
    public void setUp(){
        Book book = new Book();

        book.setTitle("Galapagos");
        book.setAuthor("Charles Darwin");
        book.setIsbn("165498-m");
        book.setYear("1875");
        book.setPrice(15.00);

        repository.save(book);
    }

    @After
    public void tearDown(){
        List<Book> books = (List<Book>) repository.findAll();

        for (Book book : books){
            repository.delete(book.getId());
        }

    }

    @Test
    public void findByAuthorShouldReturnBook(){
        List<Book> books = repository.findByAuthor("Charles Darwin");
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("Charles Darwin");
    }

    @Test
    public void createNewBook(){
        Book book = new Book("ABC", "Unknown", "1800", "14474354-n", 18.00);
        repository.save(book);
        assertThat(book.getId()).isNotNull();
    }
}
