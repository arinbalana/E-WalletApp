package com.arin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.arin.entity.User;
import com.arin.entity.Wallet;
import com.arin.repository.UserRepository;
import com.arin.repository.WalletRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private WalletRepository walletRepo;
	
	public User registerUser(User user) {
		user.setPassword(new BCryptPasswordEncoder(12).encode(user.getPassword()));
		User savedUser = userRepo.save(user);
		Wallet wallet = new Wallet();
		wallet.setUser(savedUser);
		wallet.setBalance(0.0);
		walletRepo.save(wallet);
		
		return savedUser;	
	}
}
