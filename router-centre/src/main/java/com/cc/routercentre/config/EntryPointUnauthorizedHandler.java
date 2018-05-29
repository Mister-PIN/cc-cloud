package com.cc.routercentre.config;

import com.alibaba.fastjson.JSONObject;
import com.cc.routercentre.common.ResponseMessage;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EntryPointUnauthorizedHandler implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException {
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json; charset=utf-8");
        ResponseMessage message = new ResponseMessage();

        if(e instanceof BadCredentialsException){ /**身份认证未通过*/
            message.setCode(403);
            message.setMessage("Account or password error");
        }else{
            message.setCode(403);
            message.setMessage(e.getMessage());
        }
        httpServletResponse.getWriter().write(JSONObject.toJSONString(message));
    }
}
