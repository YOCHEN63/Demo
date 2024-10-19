package com.example.demo.dao;

import com.example.demo.Domain.UserDO;
import org.apache.catalina.User;

import java.util.List;

public interface UserDAO {

    UserDO findById(Long id);

    UserDO findByUsername(String username);

    List<UserDO> findAll();

    void save(UserDO user);

    void update(UserDO user);

    void delete(Long id);
}
