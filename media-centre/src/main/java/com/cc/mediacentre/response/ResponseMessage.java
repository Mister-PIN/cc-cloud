package com.cc.mediacentre.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseMessage implements Serializable {
    private Integer code = 200;
    private String message;
    private String status = "success";

}
