package org.example.controller;


import org.example.pojo.Book;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;


    @RequestMapping("/{bid}")
    Book findBookById(@PathVariable("bid") int bid){
        return bookService.getBookById(bid);
    }

}
