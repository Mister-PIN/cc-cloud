package com.cc.auth.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultMessage implements Serializable {
    private Integer code = 200;
    private String message = "success";
    private String token;
    private Object data;

}
