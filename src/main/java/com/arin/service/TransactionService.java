package com.arin.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arin.entity.Transaction;
import com.arin.entity.User;
import com.arin.entity.Wallet;
import com.arin.repository.TransactionRepository;
import com.arin.repository.UserRepository;
import com.arin.repository.WalletRepository;

import jakarta.transaction.Transactional;

@Service
public class TransactionService {
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private WalletRepository walletRepo;
	
	@Autowired
	private TransactionRepository trxRepo;
	
	@Transactional
	public String transfer(Long senderId, Long recieverId, double amount) {
		User sender = userRepo.findById(senderId).orElseThrow();
		User reciever = userRepo.findById(recieverId).orElseThrow();
		
		Wallet senderWallet = walletRepo.findByUser(sender).orElseThrow();
		Wallet recieverWallet = walletRepo.findByUser(reciever).orElseThrow();
		
		if(senderWallet.getBalance() < amount) {
			return "Unsufficient Balance!";
		}
		
		senderWallet.setBalance(senderWallet.getBalance() - amount);
		recieverWallet.setBalance(recieverWallet.getBalance() + amount);
		
		walletRepo.save(senderWallet);
		walletRepo.save(recieverWallet);
		
		Transaction trx = new Transaction();
		trx.setSender(sender);
		trx.setReciever(reciever);
		trx.setAmount(amount);
		trx.setTimestamp(LocalDateTime.now());
		trx.setStatus("SUCCESS");
		trxRepo.save(trx);
		return "Transfer Successful!";
	}
	
	public List<Transaction> getTransactions(Long userId){
		User user = userRepo.findById(userId).orElseThrow();
		return trxRepo.findBySenderOrReciever(user, user);
	}
	

}
