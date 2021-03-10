package com.example.covid.security.security;

import java.util.Collection;
import java.util.Iterator;

import cn.hutool.core.collection.CollUtil;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

/*
 * 动态权限决策管理器，用于判断用户是否有访问权限
 * */
public class JwtDynamicAccessdecisionManager implements AccessDecisionManager {

	@Override
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		// TODO Auto-generated method stub
		if(CollUtil.isEmpty(configAttributes)) {
			return;
		}
		Iterator<ConfigAttribute> iterator=configAttributes.iterator();
		while(iterator.hasNext()) {
			ConfigAttribute configAttribute=iterator.next();
			//将所访问的资源或用户拥有资源进行对比
			String needAuthority=configAttribute.getAttribute();
			for(GrantedAuthority grantedAuthority:authentication.getAuthorities()) {
				if(needAuthority.trim().equals(grantedAuthority.getAuthority())) {
					return;
				}
			}
		}
		throw new AccessDeniedException("抱歉，您没有权限！");
	}

	@Override
	public boolean supports(ConfigAttribute attribute) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return true;
	}

}
