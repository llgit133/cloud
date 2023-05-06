package org.example.service.serviceimpl;


import org.example.mapper.BookMapper;
import org.example.pojo.Book;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public Book getBookById(int bid) {
        return bookMapper.getBookById(bid);
    }
}
