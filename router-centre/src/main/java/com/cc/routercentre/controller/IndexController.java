package com.cc.routercentre.controller;

import com.cc.routercentre.common.ResponseMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }


    @RequestMapping("/loginFailure")
    @ResponseBody
    public ResponseMessage loginFailure(){
        ResponseMessage message = new ResponseMessage();
        message.setCode(500);
        message.setMessage("Account or password error");
        return message;
    }
}
