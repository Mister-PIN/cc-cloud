package com.cc.routercentre.config;

import com.alibaba.fastjson.JSONObject;
import com.cc.routercentre.common.RouterConstant;
import com.cc.routercentre.common.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String authHeader = request.getHeader(RouterConstant.tokenHeader);
        UserDetails userDetails = null;
        if (authHeader != null) {
            try {
                userDetails = this.userDetailsService.loadUserByUsername(authHeader);
                if (userDetails != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }catch (Exception e){
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json; charset=utf-8");
                ResponseMessage message = new ResponseMessage();
                message.setCode(RouterConstant.UNAUTHORIZED);
                message.setMessage("token is expired");
                response.getWriter().write(JSONObject.toJSONString(message));
                return;
            }
        }

        chain.doFilter(request, response);

        if (userDetails != null && response.getStatus()==200 && !userDetails.isAccountNonExpired()) {
            response.setStatus(203);
        }
    }
}
