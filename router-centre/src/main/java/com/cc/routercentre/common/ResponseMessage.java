package com.cc.routercentre.common;

import lombok.Data;

@Data
public class ResponseMessage {
    private Integer code = 200;
    private String message = "success";
    private String token;
    private Object data;
}
