package com.cc.auth.common;


import com.cc.auth.entity.User;
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
    private Long expiration = 172800L;
    private String secret = "cc_secret";
    private String CLAIMS_USER_ID = "userId";
    private String CLAIMS_USER_ROLE = "roles";
    private String CLAIMS_CREATED = "created";
    /**
     * 生成token
     * @param user
     * @return
     */
    public String generateToken(User user) {
        Map<String, Object> claims = new HashMap();
        claims.put(CLAIMS_USER_ID, user.getId());
        claims.put(CLAIMS_CREATED, this.generateCurrentDate());
        claims.put(CLAIMS_USER_ROLE,user.getRoles());
        return this.generateToken(claims);
    }

    /**
     * 获取用户创建日期
     * @param token
     * @return
     */
    public Date getCreatedDateFromToken(String token) {
        Claims claims = this.getClaimsFromToken(token);
        Date created = new Date((Long) claims.get(CLAIMS_CREATED));
        return created;
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

    /**
     * 过期时间 秒
     * @return
     */
    private Date generateExpirationDate() {
        Date date = new Date(System.currentTimeMillis() + (this.expiration * 1000));
        System.out.println("Expiration：" + date);
        return date;
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

    /**
     *
     * @param claims
     * @return
     */
    private String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(this.generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, this.secret)
                .compact();
    }

}
