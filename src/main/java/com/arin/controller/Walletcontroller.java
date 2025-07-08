package com.arin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arin.entity.Transaction;
import com.arin.service.TransactionService;
import com.arin.service.WalletService;

@RestController
@RequestMapping("/api/wallet")
public class Walletcontroller {
	@Autowired
	private WalletService walletService;
	
	@Autowired
	private TransactionService transactionService;

	@PostMapping("/topup")
	public ResponseEntity<String> topUp(@RequestParam Long userId,
			                            @RequestParam double amount){
		return ResponseEntity.ok(walletService.topUp(amount, userId));
	}
	
	@GetMapping("/balance")
    public ResponseEntity<Double> getBalance(@RequestParam Long userId) {
        return ResponseEntity.ok(walletService.getBalance(userId));
    }
}
