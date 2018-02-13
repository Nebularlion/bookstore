package com.bookstore.Bookstore.config;


import com.bookstore.Bookstore.model.Book;
import com.bookstore.Bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner{

    @Autowired
    private BookRepository repository;

    @Override
    public void run(String... strings) throws Exception {

        Book book = new Book();
        Book book2 = new Book();

        book.setTitle("The Origin of Species");
        book.setAuthor("Charles Darwin");
        book.setIsbn("123456-25");
        book.setPrice(10.00);
        book.setYear("1859");

        book2.setTitle("Sapiens: A Brief History of Humankind");
        book2.setAuthor("Yuval Noah Harari");
        book2.setIsbn("16764657-78");
        book2.setPrice(19.00);
        book2.setYear("2011");

        repository.save(book);
        repository.save(book2);
    }
}
