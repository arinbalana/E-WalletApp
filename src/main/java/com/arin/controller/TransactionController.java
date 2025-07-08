package com.arin.controller;

import com.arin.entity.Transaction;
import com.arin.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(@RequestParam Long senderId,
                                           @RequestParam Long receiverId,
                                           @RequestParam double amount) {
        return ResponseEntity.ok(transactionService.transfer(senderId, receiverId, amount));
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> getTransactions(@RequestParam Long userId) {
        return ResponseEntity.ok(transactionService.getTransactions(userId));
    }
}
