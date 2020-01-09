package com.oracle.springbootrest.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.oracle.springbootrest.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    @PostMapping("/user")
    public R<User> user(@Valid User user){
        return R.ok(user);
    }

}
