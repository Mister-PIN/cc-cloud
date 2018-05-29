package com.cc.routercentre.service;

import com.cc.routercentre.auth.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component("userDetailsService")
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private JwtTokenUtils jwtTokenUtils;
    @Override
    public UserDetails loadUserByUsername(String token) throws UsernameNotFoundException {
        return jwtTokenUtils.getUserFromToken(token);
    }
}
