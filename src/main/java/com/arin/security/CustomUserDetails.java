package com.arin.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.arin.entity.User;

public class CustomUserDetails implements UserDetails {
	
	private final User user;
	
	public CustomUserDetails (User user) {
		this.user = user;
	}
	
	 public Long getId() {
	        return user.getId();
	 }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		//  No roles/authorities yet
		return Collections.emptyList();
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getName();
	}

}
