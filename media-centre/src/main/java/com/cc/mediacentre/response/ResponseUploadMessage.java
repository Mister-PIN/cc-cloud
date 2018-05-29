package com.cc.mediacentre.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseUploadMessage implements Serializable{
    private Integer code = 200;
    private String uuid;
    private Integer partId;
    private String message;
}
