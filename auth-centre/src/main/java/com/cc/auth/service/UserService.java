package com.cc.auth.service;

import com.cc.auth.dto.UserDTO;
import com.cc.auth.entity.User;

public interface UserService {


    User getUser(String name);

    /**
     *
     * @param dto
     * @return
     */
    User add(UserDTO dto);

    /**
     *
     * @param dto
     * @return
     */
    User update(UserDTO dto);


}
