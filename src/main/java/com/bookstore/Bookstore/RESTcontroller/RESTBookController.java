package com.bookstore.Bookstore.RESTcontroller;


import com.bookstore.Bookstore.model.Book;
import com.bookstore.Bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api")
public class RESTBookController {

    @Autowired
    private BookRepository bookRepository;

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/booklist")
    public Iterable<Book> bookList(){
       return bookRepository.findAll();
    }

    @RequestMapping("/booklist/{id}")
    public Book getBook(@PathVariable("id") Long id){
        return bookRepository.findOne(id);
    }
}
