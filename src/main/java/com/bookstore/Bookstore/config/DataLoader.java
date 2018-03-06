package com.bookstore.Bookstore.config;


import com.bookstore.Bookstore.model.Book;
import com.bookstore.Bookstore.model.Category;
import com.bookstore.Bookstore.model.User;
import com.bookstore.Bookstore.repository.BookRepository;
import com.bookstore.Bookstore.repository.CategoryRepository;
import com.bookstore.Bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner{

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... strings) throws Exception {

        Category category = new Category();
        Category category1 = new Category();

        category.setName("Science");
        category1.setName("Horror");

        category = categoryRepository.save(category);
        category1 = categoryRepository.save(category1);

        Book book = new Book();
        Book book2 = new Book();

        book.setTitle("The Origin of Species");
        book.setAuthor("Charles Darwin");
        book.setIsbn("123456-25");
        book.setPrice(10.00);
        book.setYear("1859");
        book.setCategory(category);

        book2.setTitle("Sapiens: A Brief History of Humankind");
        book2.setAuthor("Yuval Noah Harari");
        book2.setIsbn("16764657-78");
        book2.setPrice(19.00);
        book2.setYear("2011");
        book2.setCategory(category1);

        bookRepository.save(book);
        bookRepository.save(book2);

        User user1 = new User();
        User user2 = new User();

        user1.setUsername("user");
        user1.setPasswordHash("$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6");
        user1.setRole("USER");

        user2.setUsername("admin");
        user2.setPasswordHash("$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C");
        user2.setRole("ADMIN");

        user1 = userRepository.save(user1);
        user2 = userRepository.save(user2);
    }
}
