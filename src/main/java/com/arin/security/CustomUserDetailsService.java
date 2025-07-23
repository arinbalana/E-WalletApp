package com.arin.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.arin.repository.UserRepository;
import com.arin.entity.User;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	@Autowired
	private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		User u = repo.findByName(name)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with email: "+name));

		return new CustomUserDetails(u);
	}

}
