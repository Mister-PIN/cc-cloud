package com.cc.auth.service.impl;

import com.cc.auth.dao.UserRespositry;
import com.cc.auth.entity.User;
import com.cc.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRespositry userRespositry;


    @Override
    public User getUser(String name) {
        User user = userRespositry.findUserByUsername(name);
        if (null == user) {
            user = userRespositry.findUserByTelephone(name);
        }
        return user;
    }
}
