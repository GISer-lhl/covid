package com.example.covid.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
/*
 * 实现创建token与校验token功能
 * */
@Component
public class JwtTokenUtils implements InitializingBean{

    private static final String CLAIM_KEY_USERNAME="sub";
    private static final String CLAIM_KEY_CREATED="created";
    
    @Value("${jwt.token-secret}")
    private String secret;
    @Value("${jwt.token-expiration}")
    private Long expiration;
    @Value("${jwt.token-prefix}")
    private String tokenHead;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	public  String createToken (Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(new Date())
                .setExpiration(getExpirationDate())
                .compressWith(CompressionCodecs.DEFLATE)
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();
    }

    public Date getExpirationDateFromToken(String token) {
        Date expiration;
        try {
            final Claims claims = getClaimsFromToken(token);
            expiration = claims.getExpiration();
        } catch (Exception e) {
            expiration = null;
        }
        return expiration;
    }
    
    /*
     * 从token中获取JWT中的负载
     * */
    private Claims getClaimsFromToken(String token) {
        Claims claims=null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }
    /*
     * 生成token的过期时间
     * */
    private Date getExpirationDate() {
    	return new Date(System.currentTimeMillis()+expiration*1000);
    }

    /*
     * 从token中获取登录用户名
     * */
    public String getUserNameFromToken(String token) {
    	String username;
    	try {
    		Claims claims=getClaimsFromToken(token);
    		username=claims.getSubject();
    	}catch(Exception ex) {
    		username=null;
    	}
    	return username;
    }
    /*
     * 验证token是否还有效
     * */
    public boolean validateToken(String token,UserDetails userDetails) {
    	String usernameString=getUserNameFromToken(token);
    	return usernameString.equals(userDetails.getUsername())&&!isTokenExpired(token);
    }
    /*
     * 判断token是否失效
     * */
    private boolean isTokenExpired(String token) {
		Date expiredDate=getExpirationDateFromToken(token);
		return expiredDate.before(new Date());
	}
    /*
     * 根据用户信息生成token
     * */
    public String getTokenByUserDetails(UserDetails userDetails) {
    	Map<String, Object> claims=new HashMap<>();
    	claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
    	claims.put(CLAIM_KEY_CREATED, new Date());
    	return createToken(claims);
    }
    
    public String refreshToken(String oldToken) {
		if(StrUtil.isEmpty(oldToken)) {
			return null;
		}
		String token=oldToken.substring(tokenHead.length());
		if(StrUtil.isEmpty(token)) {
			return null;
		}
		//token校验不通过
		Claims claims=getClaimsFromToken(token);
		if(claims==null) {
			return null;
		}
		//如果token已经过期，不支持刷新
		if(isTokenExpired(token)) {
			return null;
		}
		//如果token在有效时间内刷新过，返回原token
		if(tokenRefreshJustBefore(token,30*60)) {
			return token;
		}else {
			claims.put(CLAIM_KEY_CREATED, new Date());
			return createToken(claims);
		}		
	}
    /*
     * 判断token在指定时间内是否刚刚刷新过
     * */
    private boolean tokenRefreshJustBefore(String token,int time) {
		Claims claims=getClaimsFromToken(token);
		Date createDate=claims.get(CLAIM_KEY_CREATED, Date.class);
		Date refreshDate=new Date();
		//刷新时间在创建时间的指定时间范围内
		if(refreshDate.after(createDate)&&refreshDate.before(DateUtil.offsetSecond(createDate, time))) {
			return true;
		}
		return false;
	}
}
