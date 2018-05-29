package com.cc.auth.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "cc_user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_")
    private Long id;

    @Column(name = "username_")
    private String username;//用户ID

    @Column(name = "password_")
    private String password;//密码

    @Column(name = "telephone_")
    private String telephone;//手机号

    @Column(name = "email_")
    private String email;//邮箱

    @Column(name = "name_")
    private String name;

    @Column(name = "roles_")
    private String roles;

    @Column(name = "create_by_")
    private String createBy;

    @Column(name = "create_time_")
    private Date createTime;

    @Column(name = "update_by_")
    private Integer updateBy;

    @Column(name = "update_time_")
    private Date updateTime;

    @Column(name = "status_")
    private Integer status;

    @Column(name = "remark_")
    private String remark;
}
