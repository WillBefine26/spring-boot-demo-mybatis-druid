package com.guoxin.demo.mapper;

import com.guoxin.demo.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


/**
 * Created by guoxin on 17-3-29.
 */
public interface UserMapper {

    int insert(User user);

    int delete(int id);

    User update(User user);
}
