package com.cc.auth.dao;

import com.cc.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRespositry extends JpaRepository<User, Long> {

    /**
     * 根据用户ID获取用户
     * @param uesrname
     * @return
     */
    User findUserByUsername(String uesrname);


    /**
     * 根据电话号码获取账号
     * @param telephone
     * @return
     */
    User findUserByTelephone(String telephone);


    @Override
    User getOne(Long id);
}
