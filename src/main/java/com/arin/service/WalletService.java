package com.arin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arin.entity.User;
import com.arin.entity.Wallet;
import com.arin.repository.UserRepository;
import com.arin.repository.WalletRepository;

@Service
public class WalletService {
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private WalletRepository walletRepo;
	
	public double getBalance(Long Id) {
		User user = userRepo.findById(Id).orElseThrow();
		Wallet wallet = walletRepo.findByUser(user).orElseThrow();
		return wallet.getBalance();
	}
	
	public String topUp(double balance, Long userId) {
		User user = userRepo.findById(userId).orElseThrow();
		Wallet wallet = walletRepo.findByUser(user).orElseThrow();
		wallet.setBalance(wallet.getBalance() + balance);
		walletRepo.save(wallet);
		return "Top-Up Successfull!";
	}

}
