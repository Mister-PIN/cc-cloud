package com.cc.auth.controller;

import com.cc.auth.common.AuthConstant;
import com.cc.auth.common.JwtTokenUtils;
import com.cc.auth.common.ResultMessage;
import com.cc.auth.dao.UserRespositry;
import com.cc.auth.dto.UserDTO;
import com.cc.auth.entity.User;
import com.cc.auth.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;
    @Autowired
    private JwtTokenUtils jwtTokenUtils;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @PostMapping("/auth/login")
    public ResultMessage login(String username, String password){
        ResultMessage message = new ResultMessage();
        User user = userService.getUser(username);
        if (null != user && passwordEncoder().matches(password, user.getPassword())) {
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(user, userDTO);
            message.setData(userDTO);
            String token = jwtTokenUtils.generateToken(user);
            message.setToken(token);
        }else {
            message.setCode(AuthConstant.UNAUTHORIZED);
            message.setMessage("account or password error");
        }
        return message;
    }

    @PostMapping("/auth/add")
    public ResultMessage add(UserDTO dto){



        return null;
    }

}
