package com.guoxin.demo.controller;

import com.guoxin.demo.mapper.UserMapper;
import com.guoxin.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by guoxin on 17-3-29.
 */
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @PostMapping(value = "/user/",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String add(User user){
        int insert = userMapper.insert(user);
        return "success";
    }

    @DeleteMapping(value = "/user/{id}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String delete(@PathVariable Integer id){
        if (id == null){
            return "fail";
        }
        int delete = userMapper.delete(id);
        return String.valueOf(delete);
    }

    @PutMapping(value = "/user/",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String update(User user){
        if (user== null){
            return "fail";
        }
        User update = userMapper.update(user);
        return update.toString();
    }
}
