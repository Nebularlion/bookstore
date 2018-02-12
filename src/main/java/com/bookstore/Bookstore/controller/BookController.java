package com.bookstore.Bookstore.controller;

import com.bookstore.Bookstore.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bookstore.Bookstore.repository.BookRepository;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookRepository repository;

    @RequestMapping("/booklist")
    public String studentList(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist";


    }

    @RequestMapping(value="/add")
    public String addBook(Model model){
        model.addAttribute("book", new Book());

        return "addbook";
    }

    @RequestMapping(value="/save", method = RequestMethod.POST)
    public String save(Book book){
        repository.save(book);

        return "redirect:booklist";
    }

}
