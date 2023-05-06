package org.example.service.serviceimpl;

import org.example.detial.UserBorrowDetail;
import org.example.mapper.BorrowMapper;
import org.example.pojo.Book;
import org.example.pojo.Borrow;
import org.example.pojo.User;
import org.example.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class BorrowServiceImpl implements BorrowService {

    @Autowired
    private BorrowMapper borrowMapper;

    @Override
    public UserBorrowDetail getUserBorrowDetailByUid(int uid) {
        List<Borrow> borrow = borrowMapper.getBorrowsByUid(uid);

        RestTemplate template = new RestTemplate();
        //这里通过调用getForObject来请求其他服务，并将结果自动进行封装

        //获取User信息
        User user = template.getForObject("http://localhost:8082/users/"+uid, User.class);

        //获取每一本书的详细信息
        List<Book> bookList = borrow
                .stream()
                .map(b -> template.getForObject("http://localhost:8080/books/"+b.getBid(), Book.class))
                .collect(Collectors.toList());
        return new UserBorrowDetail(user, bookList);
    }
}
