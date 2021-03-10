package com.example.covid.security.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.covid.utils.JwtTokenUtils;
/*
 * 实现token验证的过滤器
 * */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter{
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Value("${jwt.token-header-key}")
    private String tokenHeaderKey; //token请求头Key
    @Value("${jwt.token-prefix}")
    private String tokenPrefix; //token前缀
    @Value("${jwt.token-secret}")
    private String tokenSecret; //token秘钥
	
	@Autowired
	private JwtTokenUtils jwtTokenUtils;
	
	/**
     * 解析token并生成authentication身份信息
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
    	if (request.getMethod().equals("OPTIONS")){
            //log.info("浏览器的预请求的处理..");
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "POST,GET,PUT,OPTIONS,DELETE");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Headers", "Origin,X-Requested-With,Content-Type,Accept,Authorization,token");
            return;
        }else {
        	String token = request.getHeader(tokenHeaderKey);
            //log.info("JwtAuthorizationTokenFilter >> token:{}", token);
            if (null == token || !token.startsWith(tokenPrefix + " ")) {
                chain.doFilter(request, response);
                return;
            }
            
            String username = jwtTokenUtils.getUserNameFromToken(token);
            if (null != username&&SecurityContextHolder.getContext().getAuthentication()==null) {
            	UserDetails userDetails=userDetailsService.loadUserByUsername(username);
            	if(jwtTokenUtils.validateToken(token, userDetails)) {
            		// 生成authentication身份信息
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
            	}            
            }
            chain.doFilter(request, response);
        }
    }

}
