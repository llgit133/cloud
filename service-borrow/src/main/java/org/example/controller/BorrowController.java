package org.example.controller;

import org.example.detial.UserBorrowDetail;
import org.example.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/borrows")
public class BorrowController {

   @Autowired
    private BorrowService borrowService;

    @RequestMapping("/{uid}")
    UserBorrowDetail findUserBorrows(@PathVariable("uid") int uid){
        return borrowService.getUserBorrowDetailByUid(uid);
    }
}
