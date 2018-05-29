package com.cc.routercentre.auth;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenUtils {
    //有效时间 秒
    private String secret = "cc_secret";
    private String CLAIMS_USER_ID = "userId";
    private String CLAIMS_USER_ROLE = "roles";


    /**
     * 获取用户信息
     * @param token
     * @return
     */
    public User getUserFromToken(String token) {
        Claims claims = this.getClaimsFromToken(token);
        if (claims != null) {
            User user = new User(claims.get(CLAIMS_USER_ID, Integer.class), claims.get(CLAIMS_USER_ROLE, String.class),claims.getExpiration().before(this.generateCurrentDate()));
            return user;
        }
        return null;
    }


    public Date getExpirationDateFromToken(String token) {
        Claims claims = this.getClaimsFromToken(token);
        return claims.getExpiration();
    }


    public boolean validateToken(String token){
        return !isTokenExpired(token);
    }

    private Boolean isTokenExpired(String token) {
        Date expiration = this.getExpirationDateFromToken(token);
        return expiration.before(this.generateCurrentDate());
    }

    /**
     * 当前时间
     * @return
     */
    private Date generateCurrentDate() {
        return new Date(System.currentTimeMillis());
    }


    private Claims getClaimsFromToken(String token) {
        Claims claims = Jwts.parser()
                    .setSigningKey(this.secret)
                    .parseClaimsJws(token)
                    .getBody();
        if (null == claims) {
            throw new RuntimeException("无效token");
        }
        return claims;
    }


}
