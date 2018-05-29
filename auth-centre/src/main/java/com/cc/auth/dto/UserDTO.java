package com.cc.auth.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String telephone;
    private String username;
    private String password;
    private String name;
    private String roles;
    private String sex;
    private String email;

}
