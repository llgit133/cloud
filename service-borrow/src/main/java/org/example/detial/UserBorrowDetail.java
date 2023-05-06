package org.example.detial;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.pojo.Book;
import org.example.pojo.User;

import java.util.List;

@Data
@AllArgsConstructor
public class UserBorrowDetail {
    User user;
    List<Book> bookList;
}
